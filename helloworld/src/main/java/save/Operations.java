//generated file

package save;

public abstract class Operations{

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static Number arithmeticAddition(Object a,Object b){
        if(a instanceof Number && b instanceof Number){
            Number z=(Number)a;
            Number n=(Number)b;
            if(a.getClass()==Double.class || b.getClass()==Double.class){
                return z.doubleValue()+n.doubleValue();
            }else if(b.getClass()==Float.class){
                if(a.getClass()==Long.class){
                    return z.doubleValue()+n.doubleValue();
                }else{
                    return z.floatValue()+n.floatValue();
                }
            }else if(a.getClass()==Float.class){
                if(b.getClass()==Long.class){
                    return z.doubleValue()+n.doubleValue();
                }else{
                    return z.floatValue()+n.floatValue();
                }
            }else if(b.getClass()==Long.class){
                return z.longValue()+n.longValue();
            }else if(a.getClass()==Long.class){
                return z.longValue()+n.longValue();
            }else{
                return z.intValue()+n.intValue();
            }
        }else{
            errorMessage("+",a,b);
        }
        return null;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static Number arithmeticSubtraction(Object a,Object b){
        if(a instanceof Number && b instanceof Number){
            Number z=(Number)a;
            Number n=(Number)b;
            if(a.getClass()==Double.class || b.getClass()==Double.class){
                return z.doubleValue()-n.doubleValue();
            }else if(b.getClass()==Float.class){
                if(a.getClass()==Long.class){
                    return z.doubleValue()-n.doubleValue();
                }else{
                    return z.floatValue()-n.floatValue();
                }
            }else if(a.getClass()==Float.class){
                if(b.getClass()==Long.class){
                    return z.doubleValue()-n.doubleValue();
                }else{
                    return z.floatValue()-n.floatValue();
                }
            }else if(b.getClass()==Long.class){
                return z.longValue()-n.longValue();
            }else if(a.getClass()==Long.class){
                return z.longValue()-n.longValue();
            }else{
                return z.intValue()-n.intValue();
            }
        }else{
            errorMessage("-",a,b);
        }
        return null;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static Number arithmeticMultiplication(Object a,Object b){
        if(a instanceof Number && b instanceof Number){
            Number z=(Number)a;
            Number n=(Number)b;
            if(a.getClass()==Double.class || b.getClass()==Double.class){
                return z.doubleValue()*n.doubleValue();
            }else if(b.getClass()==Float.class){
                if(a.getClass()==Long.class){
                    return z.doubleValue()*n.doubleValue();
                }else{
                    return z.floatValue()*n.floatValue();
                }
            }else if(a.getClass()==Float.class){
                if(b.getClass()==Long.class){
                    return z.doubleValue()*n.doubleValue();
                }else{
                    return z.floatValue()*n.floatValue();
                }
            }else if(b.getClass()==Long.class){
                return z.longValue()*n.longValue();
            }else if(a.getClass()==Long.class){
                return z.longValue()*n.longValue();
            }else{
                return z.intValue()*n.intValue();
            }
        }else{
            errorMessage("*",a,b);
        }
        return null;
    }

    private static void errorMessage(String op,Object a,Object b){
        String t1=a==null ? "null" : a.getClass().getName();
        String t2=b==null ? "null" : b.getClass().getName();
        System.err.println("Operator \""+op+"\" not applicable to "+t1+" and "+t2+".");
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static Number arithmeticDivision(Object a,Object b){
        if(a instanceof Number && b instanceof Number){
            Number z=(Number)a;
            Number n=(Number)b;
            if(a.getClass()==Double.class || b.getClass()==Double.class){
                return z.doubleValue()/n.doubleValue();
            }else if(b.getClass()==Float.class){
                if(a.getClass()==Long.class){
                    return z.doubleValue()/n.doubleValue();
                }else{
                    return z.floatValue()/n.floatValue();
                }
            }else if(a.getClass()==Float.class){
                if(b.getClass()==Long.class){
                    return z.doubleValue()/n.doubleValue();
                }else{
                    return z.floatValue()/n.floatValue();
                }
            }else if(b.getClass()==Long.class){
                return z.longValue()/n.longValue();
            }else if(a.getClass()==Long.class){
                return z.longValue()/n.longValue();
            }else{
                return z.intValue()/n.intValue();
            }
        }else{
            errorMessage("/",a,b);
        }
        return null;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static Boolean logicOr(Object a,Object b){
        if(a==null || b==null){
            errorMessage("or",a,b);
        }else if(a.getClass()==Boolean.class && b.getClass()==Boolean.class){
            Boolean ab=(Boolean)a;
            Boolean bb=(Boolean)b;
            return ab || bb;
        }
        return null;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static Boolean logicAnd(Object a,Object b){
        if(a==null || b==null){
            errorMessage("and",a,b);
        }else if(a.getClass()==Boolean.class && b.getClass()==Boolean.class){
            Boolean ab=(Boolean)a;
            Boolean bb=(Boolean)b;
            return ab && bb;
        }
        return null;
    }

    /**
     *
     * @param a
     * @return
     */
    public static Boolean logicNo(Object a){
        if(a==null){
            System.err.println("Operation ! not applicable to "+a+".");
        }else if(a.getClass()!=Boolean.class){
            System.err.println("Operation ! not applicable to "+a.getClass().getSimpleName()+".");
        }else{
            Boolean ab=(Boolean)a;
            return !ab;
        }
        return null;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static Boolean equal(Object a,Object b){
        if(a instanceof Number && b instanceof Number){
            return arithmeticSubtraction(a,b).doubleValue()==0;
        }else if(a==null){
            if(b==null){
                return true;
            }else{
                return b.equals(a);
            }
        }else{
            return a.equals(b);
        }
    }

    /**
     *
     * @param a
     * @return
     */
    public static Boolean notEqual(Object a,Object b){
        if(a instanceof Number && b instanceof Number){
            return arithmeticSubtraction(b,a).doubleValue()!=0;
        }
        return !equal(a,b);
    }

    /**
     *
     * @param a
     * @return
     */
    public static Boolean equalOrBigger(Object a,Object b){
        if(a instanceof Number && b instanceof Number){
            return arithmeticSubtraction(a,b).doubleValue()>=0;
        }else if(a==null && b==null){
            return true;
        }
        try{
            Comparable ac,bc;
            ac=(Comparable)a;
            bc=(Comparable)b;
            return ac.compareTo(bc)>=0;
        }catch(Exception j){
            errorMessage(">=",a,b);
            return false;
        }
    }

    /**
     *
     * @param a
     * @return
     */
    public static Boolean equalOrLesser(Object a,Object b){
        if(a instanceof Number && b instanceof Number){
            return arithmeticSubtraction(b,a).doubleValue()>=0;
        }else if(a==null && b==null){
            return true;
        }
        try{
            Comparable ac,bc;
            ac=(Comparable)a;
            bc=(Comparable)b;
            return ac.compareTo(bc)<=0;
        }catch(Exception j){
            errorMessage("<=",a,b);
            return false;
        }
    }

    /**
     *
     * @param a
     * @return
     */
    public static Boolean bigger(Object a,Object b){
        if(a instanceof Number && b instanceof Number){
            return arithmeticSubtraction(a,b).doubleValue()>0;
        }else if(a==null && b==null){
            return false;
        }
        try{
            Comparable ac,bc;
            ac=(Comparable)a;
            bc=(Comparable)b;
            return ac.compareTo(bc)>0;
        }catch(Exception j){
            errorMessage(">",a,b);
            return false;
        }
    }

    /**
     *
     * @param a
     * @return
     */
    public static Boolean lesser(Object a,Object b){
        if(a instanceof Number && b instanceof Number){
            return arithmeticSubtraction(b,a).doubleValue()>0;
        }else if(a==null && b==null){
            return false;
        }
        try{
            Comparable ac,bc;
            ac=(Comparable)a;
            bc=(Comparable)b;
            return ac.compareTo(bc)<0;
        }catch(Exception j){
            errorMessage("<",a,b);
            return false;
        }
    }
}
