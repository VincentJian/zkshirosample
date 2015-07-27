package shiro.sample;

import org.apache.shiro.SecurityUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

public class MarketingComposer extends SelectorComposer<Component> {

	private static final long serialVersionUID = -5755318834743153727L;

	@Listen("onClick = #home")
	public void home() {
		Executions.sendRedirect("/home.zul");
	}

	@Listen("onClick = #logout")
	public void logout() {
		Executions.sendRedirect("/home.zul");
		SecurityUtils.getSubject().logout();
	}

}
