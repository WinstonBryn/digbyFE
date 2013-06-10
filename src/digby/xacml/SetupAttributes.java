package digby.xacml;

import com.sun.xacml.EvaluationCtx;
import com.sun.xacml.Indenter;

import com.sun.xacml.attr.AnyURIAttribute;
import com.sun.xacml.attr.RFC822NameAttribute;
import com.sun.xacml.attr.StringAttribute;

import com.sun.xacml.ctx.Attribute;
import com.sun.xacml.ctx.RequestCtx;
import com.sun.xacml.ctx.Subject;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.HashSet;
import java.util.Set;

public class SetupAttributes {

	/**
	 * Sets up the Subject section of the request. This Request only has one
	 * Subject section, and it uses the default category. To create a Subject
	 * with a different category, you simply specify the category when you
	 * construct the Subject object.
	 * 
	 * @return a Set of Subject instances for inclusion in a Request
	 * 
	 * @throws URISyntaxException
	 *             if there is a problem with a URI
	 */
	public static Set setupSubjects(String subjec) throws URISyntaxException {
		HashSet attributes = new HashSet();

		// setup the id and value for the requesting subject
		URI subjectId = new URI(
				"urn:oasis:names:tc:xacml:1.0:subject:subject-id");
/*		RFC822NameAttribute value = new RFC822NameAttribute(
				subjec);
*/
		/*// create the subject section with two attributes, the first with
		// the subject's identity...
*/		attributes.add(new Attribute(subjectId, null, null, new StringAttribute(
		subjec)));
		// ...and the second with the subject's group membership
/*		attributes.add(new Attribute(new URI("group"),
				"admin@users.example.com", null, new StringAttribute(
						"developers")));
*/
		// bundle the attributes in a Subject with the default category
		HashSet subjects = new HashSet();
		subjects.add(new Subject(attributes));

		return subjects;
	}

	/**
	 * Creates a Resource specifying the resource-id, a required attribute.
	 * 
	 * @return a Set of Attributes for inclusion in a Request
	 * 
	 * @throws URISyntaxException
	 *             if there is a problem with a URI
	 */
	public static Set setupResource(String resourc) throws URISyntaxException {
		HashSet resource = new HashSet();

		URI resourceId=new URI("urn:oasis:names:tc:xacml:1.0:resource:resource-id");
		
		// the resource being requested
		AnyURIAttribute value = new AnyURIAttribute(new URI(
				resourc));

		// create the resource using a standard, required identifier for
		// the resource being requested
		resource.add(new Attribute(resourceId, null,
				null, new StringAttribute(resourc)));

		return resource;
	}

	/**
	 * Creates an Action specifying the action-id, an optional attribute.
	 * 
	 * @return a Set of Attributes for inclusion in a Request
	 * 
	 * @throws URISyntaxException
	 *             if there is a problem with a URI
	 */
	public static Set setupAction(String actio) throws URISyntaxException {
		HashSet action = new HashSet();

		// this is a standard URI that can optionally be used to specify
		// the action being requested
		URI actionId = new URI("urn:oasis:names:tc:xacml:1.0:action:action-id");

		// create the action
		action.add(new Attribute(actionId, null, null, new StringAttribute(
				actio)));

		return action;
	}
	public static Set setupEnvironment(String environ) throws URISyntaxException{
		HashSet envirronment = new HashSet();

		// this is a standard URI that can optionally be used to specify
		// the action being requested
		URI actionId = new URI("urn:oasis:names:tc:xacml:1.0:environment:environment-id");

		// create the action
		envirronment.add(new Attribute(actionId, null, null, new StringAttribute(
				environ)));

		return envirronment;
		
	}

}
