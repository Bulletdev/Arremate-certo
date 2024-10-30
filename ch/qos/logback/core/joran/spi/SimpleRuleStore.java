/*     */ package ch.qos.logback.core.joran.spi;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.joran.action.Action;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.util.OptionHelper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SimpleRuleStore
/*     */   extends ContextAwareBase
/*     */   implements RuleStore
/*     */ {
/*  34 */   static String KLEENE_STAR = "*";
/*     */ 
/*     */   
/*  37 */   HashMap<ElementSelector, List<Action>> rules = new HashMap<ElementSelector, List<Action>>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleRuleStore(Context paramContext) {
/*  43 */     setContext(paramContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRule(ElementSelector paramElementSelector, Action paramAction) {
/*  51 */     paramAction.setContext(this.context);
/*     */     
/*  53 */     List<Action> list = this.rules.get(paramElementSelector);
/*     */     
/*  55 */     if (list == null) {
/*  56 */       list = new ArrayList();
/*  57 */       this.rules.put(paramElementSelector, list);
/*     */     } 
/*     */     
/*  60 */     list.add(paramAction);
/*     */   }
/*     */   
/*     */   public void addRule(ElementSelector paramElementSelector, String paramString) {
/*  64 */     Action action = null;
/*     */     
/*     */     try {
/*  67 */       action = (Action)OptionHelper.instantiateByClassName(paramString, Action.class, this.context);
/*  68 */     } catch (Exception exception) {
/*  69 */       addError("Could not instantiate class [" + paramString + "]", exception);
/*     */     } 
/*  71 */     if (action != null) {
/*  72 */       addRule(paramElementSelector, action);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Action> matchActions(ElementPath paramElementPath) {
/*     */     List<Action> list;
/*  86 */     if ((list = fullPathMatch(paramElementPath)) != null)
/*  87 */       return list; 
/*  88 */     if ((list = suffixMatch(paramElementPath)) != null)
/*  89 */       return list; 
/*  90 */     if ((list = prefixMatch(paramElementPath)) != null)
/*  91 */       return list; 
/*  92 */     if ((list = middleMatch(paramElementPath)) != null) {
/*  93 */       return list;
/*     */     }
/*  95 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   List<Action> fullPathMatch(ElementPath paramElementPath) {
/* 100 */     for (ElementSelector elementSelector : this.rules.keySet()) {
/* 101 */       if (elementSelector.fullPathMatch(paramElementPath))
/* 102 */         return this.rules.get(elementSelector); 
/*     */     } 
/* 104 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   List<Action> suffixMatch(ElementPath paramElementPath) {
/* 109 */     int i = 0;
/* 110 */     ElementSelector elementSelector = null;
/*     */     
/* 112 */     for (ElementSelector elementSelector1 : this.rules.keySet()) {
/* 113 */       if (isSuffixPattern(elementSelector1)) {
/* 114 */         int j = elementSelector1.getTailMatchLength(paramElementPath);
/* 115 */         if (j > i) {
/* 116 */           i = j;
/* 117 */           elementSelector = elementSelector1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 122 */     if (elementSelector != null) {
/* 123 */       return this.rules.get(elementSelector);
/*     */     }
/* 125 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isSuffixPattern(ElementSelector paramElementSelector) {
/* 130 */     return (paramElementSelector.size() > 1 && paramElementSelector.get(0).equals(KLEENE_STAR));
/*     */   }
/*     */   
/*     */   List<Action> prefixMatch(ElementPath paramElementPath) {
/* 134 */     int i = 0;
/* 135 */     ElementSelector elementSelector = null;
/*     */     
/* 137 */     for (ElementSelector elementSelector1 : this.rules.keySet()) {
/* 138 */       String str = elementSelector1.peekLast();
/* 139 */       if (isKleeneStar(str)) {
/* 140 */         int j = elementSelector1.getPrefixMatchLength(paramElementPath);
/*     */         
/* 142 */         if (j == elementSelector1.size() - 1 && j > i) {
/* 143 */           i = j;
/* 144 */           elementSelector = elementSelector1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 149 */     if (elementSelector != null) {
/* 150 */       return this.rules.get(elementSelector);
/*     */     }
/* 152 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isKleeneStar(String paramString) {
/* 157 */     return KLEENE_STAR.equals(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   List<Action> middleMatch(ElementPath paramElementPath) {
/* 162 */     int i = 0;
/* 163 */     ElementSelector elementSelector = null;
/*     */     
/* 165 */     for (ElementSelector elementSelector1 : this.rules.keySet()) {
/* 166 */       String str1 = elementSelector1.peekLast();
/* 167 */       String str2 = null;
/* 168 */       if (elementSelector1.size() > 1) {
/* 169 */         str2 = elementSelector1.get(0);
/*     */       }
/* 171 */       if (isKleeneStar(str1) && isKleeneStar(str2)) {
/* 172 */         List<String> list = elementSelector1.getCopyOfPartList();
/* 173 */         if (list.size() > 2) {
/* 174 */           list.remove(0);
/* 175 */           list.remove(list.size() - 1);
/*     */         } 
/*     */         
/* 178 */         int j = 0;
/* 179 */         ElementSelector elementSelector2 = new ElementSelector(list);
/* 180 */         if (elementSelector2.isContainedIn(paramElementPath)) {
/* 181 */           j = elementSelector2.size();
/*     */         }
/* 183 */         if (j > i) {
/* 184 */           i = j;
/* 185 */           elementSelector = elementSelector1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 190 */     if (elementSelector != null) {
/* 191 */       return this.rules.get(elementSelector);
/*     */     }
/* 193 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 198 */     String str = "  ";
/*     */     
/* 200 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 202 */     stringBuilder.append("SimpleRuleStore ( ").append("rules = ").append(this.rules).append("  ").append(" )");
/*     */     
/* 204 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\spi\SimpleRuleStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */