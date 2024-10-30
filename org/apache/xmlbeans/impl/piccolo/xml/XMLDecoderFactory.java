/*    */ package org.apache.xmlbeans.impl.piccolo.xml;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XMLDecoderFactory
/*    */ {
/* 35 */   private static HashMap decoders = new HashMap();
/*    */   static {
/* 37 */     UTF8XMLDecoder uTF8XMLDecoder = new UTF8XMLDecoder();
/* 38 */     ASCIIXMLDecoder aSCIIXMLDecoder = new ASCIIXMLDecoder();
/* 39 */     ISO8859_1XMLDecoder iSO8859_1XMLDecoder = new ISO8859_1XMLDecoder();
/* 40 */     UnicodeBigXMLDecoder unicodeBigXMLDecoder = new UnicodeBigXMLDecoder();
/* 41 */     UnicodeLittleXMLDecoder unicodeLittleXMLDecoder = new UnicodeLittleXMLDecoder();
/* 42 */     decoders.put("UTF-8", uTF8XMLDecoder);
/* 43 */     decoders.put("UTF8", uTF8XMLDecoder);
/* 44 */     decoders.put("US-ASCII", aSCIIXMLDecoder);
/* 45 */     decoders.put("ASCII", aSCIIXMLDecoder);
/* 46 */     decoders.put("ISO-8859-1", iSO8859_1XMLDecoder);
/* 47 */     decoders.put("ISO8859_1", iSO8859_1XMLDecoder);
/* 48 */     decoders.put("UTF-16LE", unicodeLittleXMLDecoder);
/* 49 */     decoders.put("UNICODELITTLE", unicodeLittleXMLDecoder);
/* 50 */     decoders.put("UNICODELITTLEUNMARKED", unicodeLittleXMLDecoder);
/* 51 */     decoders.put("UTF-16BE", unicodeBigXMLDecoder);
/* 52 */     decoders.put("UTF-16", unicodeBigXMLDecoder);
/* 53 */     decoders.put("UNICODEBIG", unicodeBigXMLDecoder);
/* 54 */     decoders.put("UNICODEBIGUNMARKED", unicodeBigXMLDecoder);
/*    */   }
/*    */   
/*    */   public static XMLDecoder createDecoder(String paramString) throws UnsupportedEncodingException {
/* 58 */     XMLDecoder xMLDecoder = (XMLDecoder)decoders.get(paramString.toUpperCase());
/* 59 */     if (xMLDecoder != null) {
/* 60 */       return xMLDecoder.newXMLDecoder();
/*    */     }
/* 62 */     throw new UnsupportedEncodingException("Encoding '" + paramString + "' not supported");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\XMLDecoderFactory.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */