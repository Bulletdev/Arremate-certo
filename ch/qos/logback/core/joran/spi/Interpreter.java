/*     */ package ch.qos.logback.core.joran.spi;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.joran.action.Action;
/*     */ import ch.qos.logback.core.joran.action.ImplicitAction;
/*     */ import ch.qos.logback.core.joran.event.BodyEvent;
/*     */ import ch.qos.logback.core.joran.event.EndEvent;
/*     */ import ch.qos.logback.core.joran.event.StartEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Stack;
/*     */ import java.util.Vector;
/*     */ import org.xml.sax.Attributes;
/*     */ import org.xml.sax.Locator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Interpreter
/*     */ {
/*  68 */   private static List<Action> EMPTY_LIST = new Vector<Action>(0);
/*     */ 
/*     */   
/*     */   private final RuleStore ruleStore;
/*     */ 
/*     */   
/*     */   private final InterpretationContext interpretationContext;
/*     */ 
/*     */   
/*     */   private final ArrayList<ImplicitAction> implicitActions;
/*     */ 
/*     */   
/*     */   private final a cai;
/*     */ 
/*     */   
/*     */   private ElementPath elementPath;
/*     */ 
/*     */   
/*     */   Locator locator;
/*     */   
/*     */   EventPlayer eventPlayer;
/*     */   
/*     */   Stack<List<Action>> actionListStack;
/*     */   
/*  92 */   ElementPath skip = null;
/*     */   
/*     */   public Interpreter(Context paramContext, RuleStore paramRuleStore, ElementPath paramElementPath) {
/*  95 */     this.cai = new a(paramContext, this);
/*  96 */     this.ruleStore = paramRuleStore;
/*  97 */     this.interpretationContext = new InterpretationContext(paramContext, this);
/*  98 */     this.implicitActions = new ArrayList<ImplicitAction>(3);
/*  99 */     this.elementPath = paramElementPath;
/* 100 */     this.actionListStack = new Stack<List<Action>>();
/* 101 */     this.eventPlayer = new EventPlayer(this);
/*     */   }
/*     */   
/*     */   public EventPlayer getEventPlayer() {
/* 105 */     return this.eventPlayer;
/*     */   }
/*     */   
/*     */   public void setInterpretationContextPropertiesMap(Map<String, String> paramMap) {
/* 109 */     this.interpretationContext.setPropertiesMap(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InterpretationContext getExecutionContext() {
/* 116 */     return getInterpretationContext();
/*     */   }
/*     */   
/*     */   public InterpretationContext getInterpretationContext() {
/* 120 */     return this.interpretationContext;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startDocument() {}
/*     */   
/*     */   public void startElement(StartEvent paramStartEvent) {
/* 127 */     setDocumentLocator(paramStartEvent.getLocator());
/* 128 */     startElement(paramStartEvent.namespaceURI, paramStartEvent.localName, paramStartEvent.qName, paramStartEvent.attributes);
/*     */   }
/*     */ 
/*     */   
/*     */   private void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes) {
/* 133 */     String str = getTagName(paramString2, paramString3);
/* 134 */     this.elementPath.push(str);
/*     */     
/* 136 */     if (this.skip != null) {
/*     */       
/* 138 */       pushEmptyActionList();
/*     */       
/*     */       return;
/*     */     } 
/* 142 */     List<Action> list = getApplicableActionList(this.elementPath, paramAttributes);
/* 143 */     if (list != null) {
/* 144 */       this.actionListStack.add(list);
/* 145 */       callBeginAction(list, str, paramAttributes);
/*     */     } else {
/*     */       
/* 148 */       pushEmptyActionList();
/* 149 */       String str1 = "no applicable action for [" + str + "], current ElementPath  is [" + this.elementPath + "]";
/* 150 */       this.cai.addError(str1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void pushEmptyActionList() {
/* 158 */     this.actionListStack.add(EMPTY_LIST);
/*     */   }
/*     */ 
/*     */   
/*     */   public void characters(BodyEvent paramBodyEvent) {
/* 163 */     setDocumentLocator(paramBodyEvent.locator);
/*     */     
/* 165 */     String str = paramBodyEvent.getText();
/* 166 */     List<Action> list = this.actionListStack.peek();
/*     */     
/* 168 */     if (str != null) {
/* 169 */       str = str.trim();
/* 170 */       if (str.length() > 0)
/*     */       {
/* 172 */         callBodyAction(list, str);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void endElement(EndEvent paramEndEvent) {
/* 178 */     setDocumentLocator(paramEndEvent.locator);
/* 179 */     endElement(paramEndEvent.namespaceURI, paramEndEvent.localName, paramEndEvent.qName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void endElement(String paramString1, String paramString2, String paramString3) {
/* 186 */     List<Action> list = this.actionListStack.pop();
/*     */     
/* 188 */     if (this.skip != null) {
/* 189 */       if (this.skip.equals(this.elementPath)) {
/* 190 */         this.skip = null;
/*     */       }
/* 192 */     } else if (list != EMPTY_LIST) {
/* 193 */       callEndAction(list, getTagName(paramString2, paramString3));
/*     */     } 
/*     */ 
/*     */     
/* 197 */     this.elementPath.pop();
/*     */   }
/*     */   
/*     */   public Locator getLocator() {
/* 201 */     return this.locator;
/*     */   }
/*     */   
/*     */   public void setDocumentLocator(Locator paramLocator) {
/* 205 */     this.locator = paramLocator;
/*     */   }
/*     */   
/*     */   String getTagName(String paramString1, String paramString2) {
/* 209 */     String str = paramString1;
/*     */     
/* 211 */     if (str == null || str.length() < 1) {
/* 212 */       str = paramString2;
/*     */     }
/*     */     
/* 215 */     return str;
/*     */   }
/*     */   
/*     */   public void addImplicitAction(ImplicitAction paramImplicitAction) {
/* 219 */     this.implicitActions.add(paramImplicitAction);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List<Action> lookupImplicitAction(ElementPath paramElementPath, Attributes paramAttributes, InterpretationContext paramInterpretationContext) {
/* 228 */     int i = this.implicitActions.size();
/*     */     
/* 230 */     for (byte b = 0; b < i; b++) {
/* 231 */       ImplicitAction implicitAction = this.implicitActions.get(b);
/*     */       
/* 233 */       if (implicitAction.isApplicable(paramElementPath, paramAttributes, paramInterpretationContext)) {
/* 234 */         ArrayList<ImplicitAction> arrayList = new ArrayList(1);
/* 235 */         arrayList.add(implicitAction);
/*     */         
/* 237 */         return (List)arrayList;
/*     */       } 
/*     */     } 
/*     */     
/* 241 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List<Action> getApplicableActionList(ElementPath paramElementPath, Attributes paramAttributes) {
/* 248 */     List<Action> list = this.ruleStore.matchActions(paramElementPath);
/*     */ 
/*     */     
/* 251 */     if (list == null) {
/* 252 */       list = lookupImplicitAction(paramElementPath, paramAttributes, this.interpretationContext);
/*     */     }
/*     */     
/* 255 */     return list;
/*     */   }
/*     */   
/*     */   void callBeginAction(List<Action> paramList, String paramString, Attributes paramAttributes) {
/* 259 */     if (paramList == null) {
/*     */       return;
/*     */     }
/*     */     
/* 263 */     Iterator<Action> iterator = paramList.iterator();
/* 264 */     while (iterator.hasNext()) {
/* 265 */       Action action = iterator.next();
/*     */ 
/*     */       
/*     */       try {
/* 269 */         action.begin(this.interpretationContext, paramString, paramAttributes);
/* 270 */       } catch (ActionException actionException) {
/* 271 */         this.skip = this.elementPath.duplicate();
/* 272 */         this.cai.addError("ActionException in Action for tag [" + paramString + "]", actionException);
/* 273 */       } catch (RuntimeException runtimeException) {
/* 274 */         this.skip = this.elementPath.duplicate();
/* 275 */         this.cai.addError("RuntimeException in Action for tag [" + paramString + "]", runtimeException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void callBodyAction(List<Action> paramList, String paramString) {
/* 281 */     if (paramList == null) {
/*     */       return;
/*     */     }
/* 284 */     Iterator<Action> iterator = paramList.iterator();
/*     */     
/* 286 */     while (iterator.hasNext()) {
/* 287 */       Action action = iterator.next();
/*     */       try {
/* 289 */         action.body(this.interpretationContext, paramString);
/* 290 */       } catch (ActionException actionException) {
/* 291 */         this.cai.addError("Exception in end() methd for action [" + action + "]", actionException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void callEndAction(List<Action> paramList, String paramString) {
/* 297 */     if (paramList == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 302 */     Iterator<Action> iterator = paramList.iterator();
/*     */     
/* 304 */     while (iterator.hasNext()) {
/* 305 */       Action action = iterator.next();
/*     */ 
/*     */       
/*     */       try {
/* 309 */         action.end(this.interpretationContext, paramString);
/* 310 */       } catch (ActionException actionException) {
/*     */ 
/*     */         
/* 313 */         this.cai.addError("ActionException in Action for tag [" + paramString + "]", actionException);
/* 314 */       } catch (RuntimeException runtimeException) {
/*     */         
/* 316 */         this.cai.addError("RuntimeException in Action for tag [" + paramString + "]", runtimeException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public RuleStore getRuleStore() {
/* 322 */     return this.ruleStore;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\spi\Interpreter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */