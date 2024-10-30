/*    */ package org.apache.commons.text.similarity;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.apache.commons.lang3.Validate;
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
/*    */ class RegexTokenizer
/*    */   implements Tokenizer<CharSequence>
/*    */ {
/* 36 */   private static final Pattern PATTERN = Pattern.compile("(\\w)+");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CharSequence[] tokenize(CharSequence paramCharSequence) {
/* 45 */     Validate.isTrue(StringUtils.isNotBlank(paramCharSequence), "Invalid text", new Object[0]);
/* 46 */     Matcher matcher = PATTERN.matcher(paramCharSequence);
/* 47 */     ArrayList<String> arrayList = new ArrayList();
/* 48 */     while (matcher.find()) {
/* 49 */       arrayList.add(matcher.group(0));
/*    */     }
/* 51 */     return arrayList.<CharSequence>toArray((CharSequence[])new String[0]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\RegexTokenizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */