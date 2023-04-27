package fanstival.web.actions;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.SimpleMessage;
public abstract class AbstractActionBean implements ActionBean{

    protected transient ActionBeanContext context;

    protected void setMessage(String value){context.getMessages().add(new SimpleMessage(value));}

    @Override
    public ActionBeanContext getContext(){return context;}
    @Override
    public void setContext(ActionBeanContext context){this.context = context;}
}
