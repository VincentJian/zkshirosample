/**
 * 
 */
package shiro.sample;

import org.apache.shiro.SecurityUtils;
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
		if (SecurityUtils.getSubject().isRemembered()) {
			user.setValue("Welcome Back: " + SecurityUtils.getSubject().getPrincipal() + ", you need to login again to access protected page.");
		} else {
			user.setValue("");
		}
	}
}
