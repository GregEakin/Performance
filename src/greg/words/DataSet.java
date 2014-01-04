package greg.words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Greg on 1/3/14.
 */
public class DataSet {
    private final List<String> lines = new ArrayList<String>();
    private final List<Integer> paragraphStarts;
    private final String filename;
    private final int lineCount;
    private final int paragraphCount;

    public DataSet(String filename) throws IOException {
        this.filename = filename;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();

        List<Integer> starts = new ArrayList<Integer>();
        int x = 0;
        int y = 0;
        boolean inPara = false;

        for (int index = 0; index < lines.size(); index++) {
            line = lines.get(index);
            if (line.length() > 0) {
                x++;
                if (!inPara)
                    starts.add(index);
                inPara = true;
            } else if (inPara) {
                y++;
                inPara = false;
            }
        }

        lineCount = x;
        paragraphCount = y;
        paragraphStarts = starts;
    }

    public List<DataRow> Map(int paragraph) {
        List<DataRow> result = new ArrayList<DataRow>();
        List<String> data = FindParagraph(paragraph);
        for (int line = 0; line < data.size(); line++) {
            String line1 = data.get(line);
            String[] words = line1.split("\\s+");
            for (int index = 0; index < words.length; index++) {
                String word1 = words[index].toLowerCase();
                String word2 = stripWord(word1);
                if (word2.length() == 0)
                    continue;
                Position position = new Position();
                position.document = filename;
                position.paragraph = paragraph;
                position.line = line;
                position.word = index;
                DataRow dataRow = new DataRow();
                dataRow.word = word2;
                dataRow.positionData = position;
                result.add(dataRow);
            }
        }

        return result;
    }

    public String stripWord(String input) {
        //  var word2 = new string(word1.Where(char.IsLetter).ToArray());
        return input;

    }

    public int ParagraphCount() {
        return paragraphCount;
    }

    public int LineCount() {
        return lineCount;
    }

    public List<String> FindParagraph(int count) {
        List<String> results = new ArrayList<String>();
        int start = paragraphStarts.get(count);
        for (int index = start; lines.get(index).length() > 0; index++) {
            String line = lines.get(index);
            results.add(line);
        }
        return results;
    }
}
