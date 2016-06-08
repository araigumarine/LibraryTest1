package masucalib.core.util;

import java.util.Collection;
import java.util.Iterator;

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
     * @param text 文字列
     * @return 文字列が<code>null</code>または空文字なら<code>true</code>を返します。
     */
    public static final boolean isEmpty(final CharSequence text) {
        return text == null || text.length() == 0;
    }
    
    /**
     * 指定された文字列でCollectionを連結します。
     * 
     * @param collection 連結文字を格納したコレクション
     * @param separator 連結文字を結合する区切り文字
     * @return 連結された文字列
     */
    public static String join(final Collection<?> collection, final String separator) {
        if (collection == null) {
            return null;
        } else {
            return join(collection.iterator(), separator);
        }
    }
    
    /**
     * 指定された文字列でIteratorを連結します。
     * 
     * @param iterator 連結文字を格納したコレクションを走査するイテレータ
     * @param separator 連結文字を結合する区切り文字
     * @return 連結された文字列
     */
    public static String join(final Iterator<?> iterator, final String separator) {
        if (iterator == null) {
            return null;
        }
        if (!iterator.hasNext()) {
            return "";
        }
        final Object first = iterator.next();
        if (!iterator.hasNext()) {
            return first != null ? first.toString() : "";
        }
        
        final StringBuilder buf = new StringBuilder(256);
        if (first != null) {
            buf.append(first);
        }
        
        do {
            if (!iterator.hasNext()) {
                break;
            }
            if (separator != null) {
                buf.append(separator);
                final Object obj = iterator.next();
                if (obj != null) {
                    buf.append(obj);
                }
            }
        } while (true);
        
        return buf.toString();
    }
    
    /**
     * 指定された文字列で配列を連結します。
     *
     * @param array 連結文字を格納した配列
     * @param separator 連結文字を結合する区切り文字
     * @return 連結された文字列
     */
    public static String join(final Object array[], final String separator) {
        if (array == null) {
            return null;
        } else {
            return join(array, separator, 0, array.length);
        }
    }

    /**
     * 指定された文字列で配列の指定範囲で連結します。
     *
     * @param array 連結文字を格納した配列
     * @param separator 連結文字を結合する区切り文字
     * @param startIndex 配列の連結開始位置
     * @param endIndex 配列の連結終了位置
     * @return 連結された文字列
     */
    public static String join(final Object array[], final String separator,
            final int startIndex, final int endIndex) {
        if (array == null) {
            return null;
        }

        String sep = separator;
        if (sep == null) {
            sep = "";
        }
        int bufSize = endIndex - startIndex;
        if (bufSize <= 0) {
            return "";
        }
        bufSize *=
            (array[startIndex] != null
                ? array[startIndex].toString().length()
                : 16) + sep.length();
        final StringBuilder buf = new StringBuilder(bufSize);
        for (int i = startIndex; i < endIndex; i++) {
            if (i > startIndex) {
                buf.append(sep);
            }
            if (array[i] != null) {
                buf.append(array[i]);
            }
        }

        return buf.toString();
    }
    
    /**
     * 指定された文字列が<code>null</code> または空の場合、規定の文字列へ置き換えた文字列を返します。
     * 
     * @param str 文字列
     * @param defaultString 規定の文字列
     * @return 指定された文字列。または規定の文字列
     */
    public static String defaultString(final String str, final String defaultString) {
        return isEmpty(str) ? defaultString : str;
    }
    
    /**
     * 文字列が等しいかどうかを判定します。
     * 
     * @param str1 比較文字列1
     * @param str2 比較文字列2
     * @return true:文字列が等しい（両方とも<code>null</code>の場合も含む） false:文字列が等しくない
     */
    public static boolean equals(final String str1, final String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }
    
    /**
     * 複数の空白を1つにまとめる
     * @param str 入力文字列
     * @return まとめ文字列
     */
    public static String squeezeSpace(final String str) {
        return str == null ? str : str.replaceAll("\\s{2,}", " ").trim();
    }
}
