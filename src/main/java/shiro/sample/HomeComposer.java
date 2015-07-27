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
		if(SecurityUtils.getSubject().isAuthenticated()) {
			user.setValue("Welcome: " + SecurityUtils.getSubject().getPrincipal());
		} else {
			user.setValue("");
		}
	}
}
