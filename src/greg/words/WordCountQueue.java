package greg.words;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Greg on 1/3/14.
 */
public class WordCountQueue {
    private final ConcurrentLinkedQueue<DataRow> queue = new ConcurrentLinkedQueue<DataRow>();
    private final Dictionary<String, List<Position>> full = new Hashtable<String, List<Position>>();
    private final DataSet dataSet;

    public WordCountQueue(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    public Dictionary<String, List<Position>> fullAccessor() {
        return full;
    }

    public void fastMax() {

    }

    public void slowMap() {
        for (int index = 0; index < dataSet.ParagraphCount(); index++) {
            map(index);
        }
    }

    public void map(int paragraph) {
        List<DataRow> lines = dataSet.Map(paragraph);
        for (DataRow dataRow : lines) {
            queue.add(dataRow);
        }
    }

    public void reduce() {
        DataRow dataRow = queue.poll();
        while (dataRow != null) {
            List<Position> value = full.get(dataRow.word);
            if (value != null) {
                value.add(dataRow.positionData);
            } else {
                List<Position> p = new ArrayList<Position>();
                p.add(dataRow.positionData);
                full.put(dataRow.word, p);
            }
            dataRow = queue.poll();
        }
    }
}
