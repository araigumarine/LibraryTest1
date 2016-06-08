package masucalib.core.util;

/**
 * 文字列操作ユーティリティクラス
 * 
 * @author masucal
 */
public class StringUtil {
    
    protected StringUtil() {
    }
    
    /**
     * ブランクかどうか返します。
     * 
     * @param str 文字列
     * @return ブランクかどうか
     */
    public static boolean isBlank(final CharSequence str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }   
        return true;
    }
    
    /**
     * ブランクではないかどうかを返します。
     * 
     * @param str 文字列
     * @return ブランクではないかどうか
     * @see #isBlank(java.lang.CharSequence) 
     */
    public static boolean isNotBlank(final CharSequence str) {
        return !isBlank(str);
    }
    
    /**
     * 文字列が<code>null</code>または空文字なら<code>true</code>を返します。
     * @param text
     * @return
     * @deprecated
     */
    @Deprecated
    public static final boolean isEmpty(final CharSequence text) {
        return text == null || text.length() == 0;
    }
}
