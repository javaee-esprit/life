package ego.life.web.converters;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ego.life.domain.Agent;
import ego.life.web.beans.HelperBean;

@FacesConverter("ac")
public class AgentConverter implements Converter{
	
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Agent equivalentAgent = null;
		HelperBean helperBean = context.getApplication().evaluateExpressionGet(context, "#{helperBean}", HelperBean.class);
		equivalentAgent = helperBean.find(value);
		if (equivalentAgent==null) {
			equivalentAgent = new Agent();
			equivalentAgent.setName(((HtmlInputText)component).getSubmittedValue().toString());
		}
		logger.log(Level.INFO, "S->O : "+value+"->"+equivalentAgent);
		return equivalentAgent;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String equivalentString = null;
		equivalentString = ((Agent)value).getName();
		logger.log(Level.INFO, "O->S : "+value+"->"+equivalentString);
		return equivalentString;
	}

}
