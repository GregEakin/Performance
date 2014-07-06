package greg.words;

import org.junit.Assert;
import org.junit.Test;

import java.util.Enumeration;
import java.util.List;

/**
 * Created by Greg on 1/3/14.
 */
public class WordCountQueueTests {
    @Test
    public void TestMethod2() throws Exception {
        DataSet dataSet = new DataSet("out\\production\\Performance\\greg\\words\\kafka.txt");
        WordCountQueue x = new WordCountQueue(dataSet);
        x.map(81);
        x.reduce();
        for (Enumeration<String> e = x.fullAccessor().keys(); e.hasMoreElements(); ){
            String key = e.nextElement();
            List<Position> value = x.fullAccessor().get(key);
            System.out.println(key + " " + value.size());
        }
    }

    @Test
    public void SlowReduceTest() throws Exception {
        DataSet dataSet = new DataSet("out\\production\\Performance\\greg\\words\\kafka.txt");
        WordCountQueue x = new WordCountQueue(dataSet);
        x.slowMap();
        x.reduce();

        // Assert.AreEqual(2612, x.FullAccessor.Count);

        List<Position> sisters = x.fullAccessor().get("sister's");
        Assert.assertEquals(5, sisters.size());
        System.out.println("sister's " + sisters.size());
        for (Position position : sisters) {
            System.out.println("    " + position.document + ", " + position.paragraph + ", " + position.line + ", " + position.word);
        }
    }
}
