/*    */ package org.apache.xmlbeans.xml.stream.events;
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
/*    */ public class ElementTypeNames
/*    */ {
/*    */   public static String getName(int paramInt) {
/* 22 */     switch (paramInt) { case 1:
/* 23 */         return "XML_EVENT";
/* 24 */       case 2: return "START_ELEMENT";
/* 25 */       case 4: return "END_ELEMENT";
/* 26 */       case 8: return "PROCESSING_INSTRUCTION";
/* 27 */       case 16: return "CHARACTER_DATA";
/* 28 */       case 32: return "COMMENT";
/* 29 */       case 64: return "SPACE";
/* 30 */       case 128: return "NULL_ELEMENT";
/* 31 */       case 256: return "START_DOCUMENT";
/* 32 */       case 512: return "END_DOCUMENT";
/* 33 */       case 1024: return "START_PREFIX_MAPPING";
/* 34 */       case 4096: return "CHANGE_PREFIX_MAPPING";
/* 35 */       case 2048: return "END_PREFIX_MAPPING";
/* 36 */       case 8192: return "ENTITY_REFERENCE"; }
/* 37 */      return "";
/*    */   }
/*    */   
/*    */   public static int getType(String paramString) {
/* 41 */     if (paramString.equals("XML_EVENT"))
/* 42 */       return 1; 
/* 43 */     if (paramString.equals("START_ELEMENT")) return 2;
/*    */     
/* 45 */     if (paramString.equals("END_ELEMENT")) return 4; 
/* 46 */     if (paramString.equals("PROCESSING_INSTRUCTION"))
/* 47 */       return 8; 
/* 48 */     if (paramString.equals("CHARACTER_DATA"))
/* 49 */       return 16; 
/* 50 */     if (paramString.equals("COMMENT"))
/* 51 */       return 32; 
/* 52 */     if (paramString.equals("SPACE"))
/* 53 */       return 64; 
/* 54 */     if (paramString.equals("NULL_ELEMENT"))
/* 55 */       return 128; 
/* 56 */     if (paramString.equals("START_DOCUMENT"))
/* 57 */       return 256; 
/* 58 */     if (paramString.equals("END_DOCUMENT"))
/* 59 */       return 512; 
/* 60 */     if (paramString.equals("START_PREFIX_MAPPING"))
/* 61 */       return 1024; 
/* 62 */     if (paramString.equals("CHANGE_PREFIX_MAPPING"))
/* 63 */       return 4096; 
/* 64 */     if (paramString.equals("ENTITY_REFERENCE"))
/* 65 */       return 8192; 
/* 66 */     if (paramString.equals("END_PREFIX_MAPPING")) {
/* 67 */       return 2048;
/*    */     }
/* 69 */     return 128;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\xml\stream\events\ElementTypeNames.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */