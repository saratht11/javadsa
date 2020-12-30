package Stack;

public class CrawlerLogFolder {
    public static void main(String[] args) {
        CrawlerLogFolder folder = new CrawlerLogFolder();
        String[] logs = {"d1/", "d2/", "../", "d21/", "./"};
        System.out.println(folder.minOperations(logs));
    }

    public int minOperations(String[] logs) {
        final String stay = "./";
        final String moveBack = "../";
        int count = 0;
        for (String current : logs) {
            switch (current) {
                case stay:
                    break;
                case moveBack:
                    count = count == 0 ? count : count - 1;
                    break;
                default:
                    count++;
                    break;
            }
        }

        return count;
    }
    public int minOperations02(String[] logs) {
        int distance = 0;
        for (String log : logs) {
            if (log.equals("./")) {
            } else if (log.equals("../")) {
                if (distance == 0) {
                } else {
                    distance--;
                }
            } else {
                distance++;
            }
        }

        return distance;
    }

}
