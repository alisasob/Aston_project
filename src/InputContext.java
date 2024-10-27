import java.util.ArrayList;

public class InputContext {
    private InputStrategy context;
    public InputContext(InputStrategy context){
        this.context = context;
    }

    public ArrayList<Object> inputValues(){
        return context.getValues();
    }
}
