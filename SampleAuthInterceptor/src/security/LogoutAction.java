/**
 * 
 */
package security;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Action;

/**
 * @author Ernest Lee
 * 
 */
public class LogoutAction implements ServletRequestAware {
	HttpServletRequest request = null;

	public void setServletRequest(final HttpServletRequest request) {
		this.request = request;
	}

	public String execute() throws Exception {
		request.getSession().invalidate();
		return Action.SUCCESS;
	}

}
