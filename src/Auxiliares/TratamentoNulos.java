/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Auxiliares;

import java.math.BigDecimal;

/**
 *
 * @author dti
 */
public class TratamentoNulos{
    private static TratarNulos<String> TratarString=new TratarNulos<String>();
    private static TratarNulos<Integer> TratarInt=new TratarNulos<Integer>();
    private static TratarNulos<Float> TratarFloat=new TratarNulos<Float>();
    private static TratarNulos<BigDecimal> TratarBigDecimal=new TratarNulos<BigDecimal>();
    private static TratarNulos<Long> TratarLong=new TratarNulos<Long>();
    private static TratarNulos<Boolean> TratarBoolean = new TratarNulos<Boolean>();
    //private TratarNulos<T> TratarGenerico=new TratarNulos<T>();

    /**
     * @return the TratarString
     */
    public static TratarNulos<String> getTratarString() {
        return TratarString;
    }

    /**
     * @param aTratarString the TratarString to set
     */
    public static void setTratarString(TratarNulos<String> aTratarString) {
        TratarString = aTratarString;
    }

    /**
     * @return the TratarInt
     */
    public static TratarNulos<Integer> getTratarInt() {
        return TratarInt;
    }

    /**
     * @param aTratarInt the TratarInt to set
     */
    public static void setTratarInt(TratarNulos<Integer> aTratarInt) {
        TratarInt = aTratarInt;
    }

    /**
     * @return the TratarFloat
     */
    public static TratarNulos<Float> getTratarFloat() {
        return TratarFloat;
    }

    /**
     * @param aTratarFloat the TratarFloat to set
     */
    public static void setTratarFloat(TratarNulos<Float> aTratarFloat) {
        TratarFloat = aTratarFloat;
    }

    /**
     * @return the TratarBigDecimal
     */
    public static TratarNulos<BigDecimal> getTratarBigDecimal() {
        return TratarBigDecimal;
    }

    /**
     * @param aTratarBigDecimal the TratarBigDecimal to set
     */
    public static void setTratarBigDecimal(TratarNulos<BigDecimal> aTratarBigDecimal) {
        TratarBigDecimal = aTratarBigDecimal;
    }

    /**
     * @return the TratarLong
     */
    public static TratarNulos<Long> getTratarLong() {
        return TratarLong;
    }

    /**
     * @param aTratarLong the TratarLong to set
     */
    public static void setTratarLong(TratarNulos<Long> aTratarLong) {
        TratarLong = aTratarLong;
    }

    /**
     * @return the TratarBoolean
     */
    public static TratarNulos<Boolean> getTratarBoolean() {
        return TratarBoolean;
    }

    /**
     * @param aTratarBoolean the TratarBoolean to set
     */
    public static void setTratarBoolean(TratarNulos<Boolean> aTratarBoolean) {
        TratarBoolean = aTratarBoolean;
    }

    /**
     * @return the TratarGenerico
     */
   
  
}
