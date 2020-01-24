package example;

public class KafkaSource {

    public static class Quote {

        private String skuId;
        private String activeStatus;
        private String maxQty;

        public Quote(String skuId, String activeStatus, String maxQty) {
            this.skuId = skuId;
            this.activeStatus = activeStatus;
            this.maxQty = maxQty;
        }
    }

    private KafkaPublisher reader;

    public KafkaSource(KafkaPublisher reader) {
        this.reader = reader;
    }

    public Quote nextEvent() {
        String line = reader.ingest();
        if (line == null)
            return null;
        return toQuote(line);
    }

    private Quote toQuote(String line) {

        String[] tokens = line.split("\\|");
        return new Quote(tokens[0], tokens[1], tokens[2]);
    }
}
