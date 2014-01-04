package greg.words;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Greg on 1/3/14.
 */
public class DataSetTests {
    @Test
    public void Test1() throws Exception {
        DataSet dataSet = new DataSet("out\\production\\Performance\\greg\\words\\kafka.txt");
        Assert.assertEquals(98, dataSet.ParagraphCount());
        Assert.assertEquals(1842, dataSet.LineCount());
    }

    @Test
    public void FirstParagraphTest() throws Exception {
        DataSet dataSet = new DataSet("out\\production\\Performance\\greg\\words\\kafka.txt");
        List<String> lines = dataSet.FindParagraph(0);

        Assert.assertEquals(8, lines.size());

        final String Expected = "One morning, when Gregor Samsa woke from troubled dreams, he found";
        Assert.assertEquals(Expected, lines.get(0));
    }

    @Test
    public void MiddleParagraphTest() throws Exception {
        DataSet dataSet = new DataSet("out\\production\\Performance\\greg\\words\\kafka.txt");
        List<String> lines = dataSet.FindParagraph(81);

        Assert.assertEquals(2, lines.size());

        final String Expected = "\"what are we to do?\"";
        Assert.assertEquals(Expected, lines.get(1));
    }
}
