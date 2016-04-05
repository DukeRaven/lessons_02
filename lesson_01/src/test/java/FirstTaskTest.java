import com.kirill.firsttask.GenericStack;
import com.kirill.firsttask.StackException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kirill on 04.04.2016.
 */
public class FirstTaskTest {

    @Test
    public void test() throws Exception {
        GenericStack<Integer> stack = new GenericStack<>();
        Integer value = new Integer(1);

        Assert.assertEquals(true, stack.isEmpty());
        Assert.assertEquals(false, stack.isFull());
        Assert.assertEquals(0, stack.getSize());

        stack.push(new Integer(1));
        Assert.assertEquals(1, stack.getSize());
        Assert.assertEquals(value, stack.peek());
        Assert.assertEquals(value, stack.pop());

        Assert.assertEquals(true, stack.isEmpty());
        Assert.assertEquals(false, stack.isFull());

        List<Integer> srcList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            srcList.add(new Integer(i));
        }
        stack.pushAll(srcList);
        Assert.assertEquals(10, stack.getSize());

        List<Integer> dstList = new ArrayList<>();
        stack.popAll(dstList);

        Collections.sort(dstList);
        Assert.assertArrayEquals(srcList.toArray(), dstList.toArray());
    }

    @Test(expected = StackException.class)
    public void testPushException() throws StackException {
        GenericStack<String> stack = new GenericStack<>(0);
        stack.push("test");

    }

    @Test(expected = StackException.class)
    public void testPopException() throws StackException {
        GenericStack<Integer> stack = new GenericStack<>();
        stack.pop();
    }
}
