package fanstival.web.actions;

import net.sourceforge.stripes.action.ActionBeanContext;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class AccountActionBean extends AbstractActionBean{
    private static final String NEW_ACCOUNT = "/WEB-INF/jsp/account/AccountForm.jsp";
    private static final String SIGNON = "/WEB-INF/jsp/account/SignOnForm.jsp";
}
