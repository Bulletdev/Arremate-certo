/*    */ package oshi.hardware.platform.unix.aix;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.function.Supplier;
/*    */ import oshi.annotation.concurrent.Immutable;
/*    */ import oshi.hardware.GraphicsCard;
/*    */ import oshi.hardware.common.AbstractGraphicsCard;
/*    */ import oshi.util.ParseUtil;
/*    */ import oshi.util.Util;
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
/*    */ @Immutable
/*    */ final class AixGraphicsCard
/*    */   extends AbstractGraphicsCard
/*    */ {
/*    */   AixGraphicsCard(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
/* 58 */     super(paramString1, paramString2, paramString3, paramString4, paramLong);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static List<GraphicsCard> getGraphicsCards(Supplier<List<String>> paramSupplier) {
/* 70 */     ArrayList<AixGraphicsCard> arrayList = new ArrayList();
/* 71 */     boolean bool = false;
/* 72 */     String str1 = null;
/* 73 */     String str2 = null;
/* 74 */     ArrayList<String> arrayList1 = new ArrayList();
/* 75 */     for (String str3 : paramSupplier.get()) {
/* 76 */       String str4 = str3.trim();
/* 77 */       if (str4.startsWith("Name:") && str4.contains("display")) {
/* 78 */         bool = true; continue;
/* 79 */       }  if (bool && str4.toLowerCase().contains("graphics")) {
/* 80 */         str1 = str4; continue;
/* 81 */       }  if (bool && str1 != null) {
/* 82 */         if (str4.startsWith("Manufacture ID")) {
/* 83 */           str2 = ParseUtil.removeLeadingDots(str4.substring(14)); continue;
/* 84 */         }  if (str4.contains("Level")) {
/* 85 */           arrayList1.add(str4.replaceAll("\\.\\.+", "=")); continue;
/* 86 */         }  if (str4.startsWith("Hardware Location Code")) {
/* 87 */           arrayList.add(new AixGraphicsCard(str1, "unknown", 
/* 88 */                 Util.isBlank(str2) ? "unknown" : str2, 
/* 89 */                 arrayList1.isEmpty() ? "unknown" : String.join(",", (Iterable)arrayList1), 0L));
/* 90 */           bool = false;
/*    */         } 
/*    */       } 
/*    */     } 
/* 94 */     return (List)arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\aix\AixGraphicsCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */