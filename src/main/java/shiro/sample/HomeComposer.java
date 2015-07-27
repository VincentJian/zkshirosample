/**
 * 
 */
package shiro.sample;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;

/**
 * @author ashish
 *
 */
public class HomeComposer extends SelectorComposer<Component> {

	private static final long serialVersionUID = -7750590438470847702L;

	@Wire
	private Label user;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			user.setValue("Welcome: you are currently logged in as " + subject.getPrincipal());
		} else if (subject.isRemembered()) {
			user.setValue("Welcome Back: " + subject.getPrincipal()
					+ ", you need to login again to access protected page.");
		} else {
			user.setValue("Unknown user: you'll have to log in");
		}
	}
}
