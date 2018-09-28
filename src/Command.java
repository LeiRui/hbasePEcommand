import java.io.PrintWriter;

public class Command {
    public static void main(String[] args) throws Exception{
        PrintWriter pw  = new PrintWriter("command1.txt");
        int N=2;
        for(int i=1;i<N;i++) {
            pw.println("./hbase org.apache.hadoop.hbase.PerformanceEvaluation --nomapred " +
                    "--rows=1000000 --compress=NONE --flushCommits=false " +
                    "--writeToWAL=true --autoFlush=false --oneCon=false " +
                    "--latency=false --bloomFilter=ROW --valueSize=10 " +
                    "--columns=10 --families=1 --table=test"+i+" sequentialWrite 1 &");
        }
        pw.println("./hbase org.apache.hadoop.hbase.PerformanceEvaluation --nomapred " +
                "--rows=1000000 --compress=NONE --flushCommits=false --writeToWAL=true " +
                "--autoFlush=false --oneCon=false --latency=false --bloomFilter=ROW " +
                "--valueSize=10 --columns=10 --families=1 --table=test"+N+" sequentialWrite 1");
        pw.close();

//        PrintWriter pw = new PrintWriter("command1.txt");
//        for (int i = 1; i <= 75; i++) {
//            pw.println("disable 'test"+i+"'");
//            pw.println("drop 'test"+i+"'");
//        }
//        pw.close();
    }
}
