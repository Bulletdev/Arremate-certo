/*     */ package ch.qos.logback.core.pattern.parser;
/*     */ 
/*     */ import ch.qos.logback.core.pattern.CompositeConverter;
/*     */ import ch.qos.logback.core.pattern.Converter;
/*     */ import ch.qos.logback.core.pattern.DynamicConverter;
/*     */ import ch.qos.logback.core.pattern.LiteralConverter;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.status.ErrorStatus;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import ch.qos.logback.core.util.OptionHelper;
/*     */ import java.util.Map;
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
/*     */ class a<E>
/*     */   extends ContextAwareBase
/*     */ {
/*     */   Converter<E> head;
/*     */   Converter<E> a;
/*     */   final Node a;
/*     */   final Map D;
/*     */   
/*     */   a(Node paramNode, Map paramMap) {
/*  34 */     this.a = paramNode;
/*  35 */     this.D = paramMap;
/*     */   }
/*     */   
/*     */   Converter<E> a() {
/*  39 */     this.head = (Converter<E>)(this.a = null);
/*  40 */     for (Node node = this.a; node != null; node = node.next) {
/*  41 */       CompositeNode compositeNode; CompositeConverter<E> compositeConverter; a a1; Converter converter; SimpleKeywordNode simpleKeywordNode; DynamicConverter<E> dynamicConverter; LiteralConverter literalConverter; switch (node.type) {
/*     */         case 0:
/*  43 */           a((Converter<E>)new LiteralConverter((String)node.getValue()));
/*     */           break;
/*     */         case 2:
/*  46 */           compositeNode = (CompositeNode)node;
/*  47 */           compositeConverter = a(compositeNode);
/*  48 */           if (compositeConverter == null) {
/*  49 */             addError("Failed to create converter for [%" + compositeNode.getValue() + "] keyword");
/*  50 */             a((Converter<E>)new LiteralConverter("%PARSER_ERROR[" + compositeNode.getValue() + "]"));
/*     */             break;
/*     */           } 
/*  53 */           compositeConverter.setFormattingInfo(compositeNode.getFormatInfo());
/*  54 */           compositeConverter.setOptionList(compositeNode.getOptions());
/*  55 */           a1 = new a(compositeNode.getChildNode(), this.D);
/*  56 */           a1.setContext(this.context);
/*  57 */           converter = a1.a();
/*  58 */           compositeConverter.setChildConverter(converter);
/*  59 */           a((Converter<E>)compositeConverter);
/*     */           break;
/*     */         case 1:
/*  62 */           simpleKeywordNode = (SimpleKeywordNode)node;
/*  63 */           dynamicConverter = a(simpleKeywordNode);
/*  64 */           if (dynamicConverter != null) {
/*  65 */             dynamicConverter.setFormattingInfo(simpleKeywordNode.getFormatInfo());
/*  66 */             dynamicConverter.setOptionList(simpleKeywordNode.getOptions());
/*  67 */             a((Converter<E>)dynamicConverter);
/*     */             
/*     */             break;
/*     */           } 
/*  71 */           literalConverter = new LiteralConverter("%PARSER_ERROR[" + simpleKeywordNode.getValue() + "]");
/*  72 */           addStatus((Status)new ErrorStatus("[" + simpleKeywordNode.getValue() + "] is not a valid conversion word", this));
/*  73 */           a((Converter<E>)literalConverter);
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/*  78 */     return this.head;
/*     */   }
/*     */   
/*     */   private void a(Converter<E> paramConverter) {
/*  82 */     if (this.head == null) {
/*  83 */       this.head = (Converter<E>)(this.a = (Node)paramConverter);
/*     */     } else {
/*  85 */       this.a.setNext(paramConverter);
/*  86 */       this.a = (Node)paramConverter;
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
/*     */   DynamicConverter<E> a(SimpleKeywordNode paramSimpleKeywordNode) {
/*  99 */     String str1 = (String)paramSimpleKeywordNode.getValue();
/* 100 */     String str2 = (String)this.D.get(str1);
/*     */     
/* 102 */     if (str2 != null) {
/*     */       try {
/* 104 */         return (DynamicConverter<E>)OptionHelper.instantiateByClassName(str2, DynamicConverter.class, this.context);
/* 105 */       } catch (Exception exception) {
/* 106 */         addError("Failed to instantiate converter class [" + str2 + "] for keyword [" + str1 + "]", exception);
/* 107 */         return null;
/*     */       } 
/*     */     }
/* 110 */     addError("There is no conversion class registered for conversion word [" + str1 + "]");
/* 111 */     return null;
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
/*     */   
/*     */   CompositeConverter<E> a(CompositeNode paramCompositeNode) {
/* 124 */     String str1 = (String)paramCompositeNode.getValue();
/* 125 */     String str2 = (String)this.D.get(str1);
/*     */     
/* 127 */     if (str2 != null) {
/*     */       try {
/* 129 */         return (CompositeConverter<E>)OptionHelper.instantiateByClassName(str2, CompositeConverter.class, this.context);
/* 130 */       } catch (Exception exception) {
/* 131 */         addError("Failed to instantiate converter class [" + str2 + "] as a composite converter for keyword [" + str1 + "]", exception);
/* 132 */         return null;
/*     */       } 
/*     */     }
/* 135 */     addError("There is no conversion class registered for composite conversion word [" + str1 + "]");
/* 136 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\parser\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */