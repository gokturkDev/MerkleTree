import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashFunction {

    static private MessageDigest md;


    static public String hash(String input){
        setHashFunctionToSHA();
        byte[] byteArrayOfHash =  getDigestOfInput(input);
        return convertHashIntoHexString(byteArrayOfHash);
    }

    static private String convertHashIntoHexString(byte[] hash){

        StringBuilder hexStringPartial = convertByteArrayToStringBuilder(hash);
        String hexString = padHexStringWith0(hexStringPartial);

        return hexString;
    }

    private static String padHexStringWith0(StringBuilder hexStringPartial) {
        while (hexStringPartial.length() < 32){
            hexStringPartial.insert(0, '0');
        }

        return hexStringPartial.toString();
    }

    private static StringBuilder convertByteArrayToStringBuilder(byte[] hash) {
        return convertBytesToStringBuilder(hash);
    }

    private static StringBuilder convertBytesToStringBuilder(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));
        return hexString;
    }

    private static byte[] getDigestOfInput(String input) {
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    private static void setHashFunctionToSHA() {
        try{
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }



}
