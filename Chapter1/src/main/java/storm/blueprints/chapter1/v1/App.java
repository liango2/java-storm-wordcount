package storm.blueprints.chapter1.v1;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
import storm.blueprints.chapter1.utils.Utils;

/**
 * Hello world!
 */
public class App {

    private static final String SPOUT_SENTENCE_ID = "spout-sentence";
    private static final String BOLT_SPLIT_ID = "bolt-split";
    private static final String BOLT_COUNT_ID = "bolt-count";
    private static final String BOLT_REPORT_ID = "bolt-report";
    private static final String TOPOLOGY_NAME = "topology-word-count";

    public static void main(String[] args) {
        System.out.println("Hello World!");

        SentenceSpout sentenceSpout = new SentenceSpout();
        SplitSentenceBolt splitSentenceBolt = new SplitSentenceBolt();
        WordCountBolt wordCountBolt = new WordCountBolt();
        ReportBolt reportBolt = new ReportBolt();

        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout(SPOUT_SENTENCE_ID, sentenceSpout);
        builder.setBolt(BOLT_SPLIT_ID, splitSentenceBolt).shuffleGrouping(SPOUT_SENTENCE_ID);
        builder.setBolt(BOLT_COUNT_ID, wordCountBolt).fieldsGrouping(BOLT_SPLIT_ID, new Fields("word"));
        builder.setBolt(BOLT_REPORT_ID, reportBolt).globalGrouping(BOLT_COUNT_ID);

        Config config = new Config();
        LocalCluster localCluster = new LocalCluster();
        localCluster.submitTopology(TOPOLOGY_NAME, config, builder.createTopology());
        Utils.waitForSeconds(10);
        localCluster.killTopology(TOPOLOGY_NAME);
        localCluster.shutdown();
    }
}
