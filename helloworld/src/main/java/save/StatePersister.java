//generated file

package save;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * A function for making a state-machine persistent.
 */
public class StatePersister implements Function{

	/**
	 * Names for XML-tags or -attributes.
	 */
	static final String STATE_MACHINE="state_machine",CHILD_INDEX="index",CHILD="child",NAME="name",CLASS="type";

	/**
	 * Creates a state-machine from a given input-stream. 
	 * @param is an input-stream representing a XML-file.
	 * @return the base state for the state-machine
	 * @throws IOException when the stream could not be read
	 * @throws IllegalArgumentException when the XML-file has the wrong format
	 */
	public static BaseState fromStream(InputStream is)throws IOException,IllegalArgumentException{
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder builder=dbf.newDocumentBuilder();
			Document doc=builder.parse(is);
			Element root=doc.getDocumentElement();
			if(!root.getTagName().equals(StatePersister.STATE_MACHINE)){
				throw new IllegalArgumentException("illegal tag \""+root.getTagName()+"\"");
			}
			Node n=null;
			for(int i=0;i<root.getChildNodes().getLength();i++){
				n=root.getChildNodes().item(i);
				if(n.getNodeType()==Node.ELEMENT_NODE){
					BaseState bs=new BaseState();
					parseStateElement((Element)n,bs);
					return bs;
				}
			}
			//should not happen
			throw new IllegalArgumentException("missing node \"child\"");
		}catch(SAXException | ParserConfigurationException s){
			throw new IllegalArgumentException("document in wrong format",s);
		}
	}
	
	private static void parseStateElement(Element e,State sm)throws IllegalArgumentException{
		if(!e.getTagName().equals(StatePersister.CHILD)){
			throw new IllegalArgumentException("illegal tag \""+e.getTagName()+"\"");
		}
		State s=null;
		try{
			String att=e.getAttribute(StatePersister.CLASS);
			if(att!=null && !att.trim().isEmpty()){
				Class<?> c=Class.forName(att);
				Constructor<?> cs=c.getConstructor(int.class,State.class);
				int index=Integer.parseInt(e.getAttribute(StatePersister.CHILD_INDEX));
				s=(State)cs.newInstance(index,sm);
				sm.CHILDREN[index]=s;
			}
		}catch(Exception e1){
			throw new IllegalArgumentException("document unsuitable",e1);
		}
		if(s!=null){
			Node n;
			for(int i=0;i<e.getChildNodes().getLength();i++){
				n=e.getChildNodes().item(i);
				if(n.getNodeType()==Node.ELEMENT_NODE){
					parseStateElement((Element)n,s);
				}
			}
		}
	}
	
	/**
	 * Creates a state-machine from a given file. 
	 * @param f a file representing a XML-file.
	 * @return the base state for the state-machine
	 * @throws IOException when the stream could not be read
	 * @throws IllegalArgumentException when the XML-file has the wrong format
	 */
	public static BaseState fromFile(File f)throws IOException,IllegalArgumentException{
		FileInputStream fis=new FileInputStream(f);
		return fromStream(fis);
	}
	
	@Override
	public Object execute(State s,Object... vars){
		String name=null;
		if(vars!=null && vars.length>0){
			name=vars[0].toString();
		}
		State h=s;
		while(h.parent!=null){
			h=h.parent;
		}
		BaseState bs=(BaseState)h;
		try{
			return createDocument(bs,name);
		}catch(ParserConfigurationException e){
			return e;
		}
	}
	
	private static Document createDocument(BaseState bs,String name)throws ParserConfigurationException{
		DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc=docBuilder.newDocument();
		Element e=doc.createElement("state_machine");
		e.setAttribute(NAME,name==null ? "" : name);
		e.setAttribute("base_state",bs.getClass().getName());
		doc.appendChild(e);
		for(int i=0;i<bs.CHILDREN.length;i++){
			e.appendChild(createState(bs.CHILDREN[i],doc,i));
		}
		return doc;
	}
	
	private static Element createState(State s,Document doc,int index){
		Element parent=doc.createElement(CHILD);
		if(index>=0){
			parent.setAttribute(CHILD_INDEX,index+"");
		}
		if(s!=null){
			parent.setAttribute(NAME,s.getName());
			parent.setAttribute(CLASS,s.getClass().getName());
			for(int i=0;i<s.CHILDREN.length;i++){
				parent.appendChild(createState(s.CHILDREN[i],doc,i));
			}
		}
		return parent;
	}
}
