package digby.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import digby.fe.DigitalAsset;
import digby.fe.FEDigitalAsset;
@Path("/v1/user")
public class V1_status {

	public static ArrayList<DigitalAsset> digitalasset = new ArrayList<DigitalAsset>();
	static ArrayList<FEDigitalAsset> fedigitalasset = new ArrayList<FEDigitalAsset>();

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public DigitalAsset returnDigitalAsset(@PathParam("id") String id)
			 {
		System.out.println(id);
		DigitalAsset initial = null;
		Iterator<DigitalAsset> it = digitalasset.iterator();
		// System.out.println("Size "+digitalasset.size());

		while (it.hasNext()) {
			initial = it.next();
			if (Integer.parseInt(id) == initial.getDaId()) {
				return initial;
			} else {
				initial = null;
			}

		}

		return initial;
	}

	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response setDigitalAsset(DigitalAsset da) {
		System.out.println(da);
		String result = "digitalassetsaved" + da;
		// System.out.println("Size "+digitalasset.size());
		DigitalAsset initial = null;
		Iterator<DigitalAsset> it = digitalasset.iterator();

		while (it.hasNext()) {
			initial = it.next();
			if ((da.getDaId()) == initial.getDaId()) {
				return Response.status(503).entity(result).build();
			}	
		}
		digitalasset.add(da);
		System.out.println(da.getDaData().getDaContact());
		return Response.status(201).entity(result).build();
	}

	@PUT
	@Path("/put")
	@Consumes("application/json")
	public Response updateDigitalAsset(DigitalAsset da) {
		System.out.println(da);
		String result = "digitalassetsaved" + da;
		// System.out.println("Size "+digitalasset.size());
		DigitalAsset initial = null;
		Iterator<DigitalAsset> it = digitalasset.iterator();

		while (it.hasNext()) {
			initial = it.next();
			if ((da.getDaId()) == initial.getDaId()) {
				it.remove();
			} else {
				initial = null;
			}

		}
		digitalasset.add(da);
		System.out.println(da.getDaData().getDaContact());
		return Response.status(201).entity(result).build();

	}
	
	
	@DELETE
	@Path("/delete/{id}")
	public Response deleteDigitalAsset(@PathParam ("id") String id){
		String remove = "digitalassetremoved" + id;
		// System.out.println("Size "+digitalasset.size());
		DigitalAsset initial = null;
		Iterator<DigitalAsset> it = digitalasset.iterator();

		while (it.hasNext()) {
			initial = it.next();
			if ((Integer.parseInt(id)) == initial.getDaId()) {
				it.remove();
			} else {
				initial = null;
			}
		}
		return Response.status(201).entity(remove).build();
	}
	

	

	@POST
	@Path("/fe/adduser/post")
	@Consumes("application/json")
	public Response setFeDigitalAsset(FEDigitalAsset da) {
		System.out.println(da);
		String result = "digitalassetsaved" + da;
		// System.out.println("Size "+digitalasset.size());
		FEDigitalAsset initial = null;
		Iterator<FEDigitalAsset> it = fedigitalasset.iterator();

		while (it.hasNext()) {
			initial = it.next();
			if ((da.getFeId()) == initial.getFeId()) {
				return Response.status(503).entity(result).build();
			}	
		}
		fedigitalasset.add(da);
		System.out.println(da);
		return Response.status(201).entity(result).build();
	}
	
	
	

	@PUT
	@Path("/fe/adduser/put")
	@Consumes("application/json")
	public Response updateFeDigitalAsset(FEDigitalAsset da) {
		System.out.println(da);
		String result = "digitalassetsaved" + da;
		// System.out.println("Size "+digitalasset.size());
		FEDigitalAsset initial = null;
		Iterator<FEDigitalAsset> it = fedigitalasset.iterator();

		while (it.hasNext()) {
			initial = it.next();
			if ((da.getFeId()) == initial.getFeId()) {
				it.remove();
			}	
			else{
				initial=null;
			}
		}
		fedigitalasset.add(da);
		System.out.println(da);
		return Response.status(201).entity(result).build();
	}
	
	@GET
	@Path("/fe/adduser/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public FEDigitalAsset returnFeDigitalAsset(@PathParam("id") String id)
			throws IOException {
		System.out.println(id);
		FEDigitalAsset initial = null;
		Iterator<FEDigitalAsset> it = fedigitalasset.iterator();
		// System.out.println("Size "+digitalasset.size());

		while (it.hasNext()) {
			initial = it.next();
			if (Integer.parseInt(id) == initial.getFeId()) {
				return initial;
			} else {
				initial = null;
			}

		}

		return initial;
	}
	
	@DELETE
	@Path("/fe/adduser/delete/{id}")
	public Response deleteFeDigitalAsset(@PathParam ("id") String id){
		String remove = "digitalassetremoved" + id;
		// System.out.println("Size "+digitalasset.size());
		FEDigitalAsset initial = null;
		Iterator<FEDigitalAsset> it = fedigitalasset.iterator();

		while (it.hasNext()) {
			initial = it.next();
			if ((Integer.parseInt(id)) == initial.getFeId()) {
				it.remove();
			} else {
				initial = null;
			}
		}
		return Response.status(201).entity(remove).build();
	}
	
	
	@GET
	@Path("/fe/adduser/admin/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public FEDigitalAsset returnAdminFeDigitalAsset(@PathParam("id") String id)
			throws IOException {
		System.out.println(id);
		FEDigitalAsset initial = null;
		Iterator<FEDigitalAsset> it = fedigitalasset.iterator();
		// System.out.println("Size "+digitalasset.size());

		while (it.hasNext()) {
			initial = it.next();
			if (Integer.parseInt(id) == initial.getFeId()) {
				return initial;
			} else {
				initial = null;
			}

		}

		return initial;
	}
	
	
}
