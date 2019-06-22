package feign.feigns;

import java.util.List;

import feign.Param;
import feign.RequestLine;
import feign.feigns.MyApp.Contributor;

interface GitHub {
	  @RequestLine("GET /repos/{owner}/{repo}/contributors")
	  List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);
	}
