package crazy.test;

import java.io.File;

public class Parameters {

    private static final String USAGE = "Usage:\n java -jar gabbleduck-<version>.jar <FILE_NAME> <LINES_TO_GENERATE>";
    private String fileName;
    private Long maximumLines;

    public void extract(String... params) {

        try {

            extractAndCheckFileExistance(params[0]);
            extractAndCheckMaximumLineCount(params[1]);
        } catch (Exception e) {

            throw new IllegalArgumentException(USAGE, e);
        }
    }

    private void extractAndCheckMaximumLineCount(String number) {

        maximumLines = Long.parseLong(number);
    }

    private void extractAndCheckFileExistance(String fileName) {

        if (!new File(fileName).exists()) {

            throw new IllegalArgumentException("File does not exist.");
        }

        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public Long getMaximumLines() {
        return maximumLines;
    }
}
