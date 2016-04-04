import com.kirill.GenericStack;
import com.kirill.StackException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Kirill on 04.04.2016.
 */
public class FirstTaskTest {

    @Test
    public void test() throws Exception {
        GenericStack<Integer> stack = new GenericStack<>();
        Integer value = new Integer(1);

        Assert.assertEquals(stack.isEmpty(), true);
        Assert.assertEquals(stack.isFull(), false);
        Assert.assertEquals(stack.getSize(), 0);

        stack.push(new Integer(1));
        Assert.assertEquals(stack.pop(), value);

        Assert.assertEquals(stack.isEmpty(), true);
        Assert.assertEquals(stack.isFull(), false);
    }

    @Test(expected = StackException.class)
    public void testPushException() throws StackException {
        GenericStack<Integer> stack = new GenericStack<>();
        for (int i = 0; i < 11; i++) {
            stack.push(new Integer(i));
        }

    }

}
