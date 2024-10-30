/*     */ package org.apache.xmlbeans.impl.jam.internal.javadoc;
/*     */ 
/*     */ import com.sun.javadoc.ClassDoc;
/*     */ import com.sun.javadoc.ConstructorDoc;
/*     */ import com.sun.javadoc.Doc;
/*     */ import com.sun.javadoc.ExecutableMemberDoc;
/*     */ import com.sun.javadoc.FieldDoc;
/*     */ import com.sun.javadoc.MethodDoc;
/*     */ import com.sun.javadoc.PackageDoc;
/*     */ import com.sun.javadoc.Parameter;
/*     */ import com.sun.javadoc.ProgramElementDoc;
/*     */ import com.sun.javadoc.RootDoc;
/*     */ import com.sun.javadoc.SourcePosition;
/*     */ import com.sun.javadoc.Tag;
/*     */ import com.sun.javadoc.Type;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.StringTokenizer;
/*     */ import org.apache.xmlbeans.impl.jam.annotation.JavadocTagParser;
/*     */ import org.apache.xmlbeans.impl.jam.internal.JamServiceContextImpl;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.PrimitiveClassImpl;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MClass;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MElement;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MField;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MInvokable;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MMethod;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MParameter;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MSourcePosition;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamClassPopulator;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamServiceContext;
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
/*     */ public class JavadocClassBuilder
/*     */   extends JamClassBuilder
/*     */   implements JamClassPopulator
/*     */ {
/*     */   public static final String ARGS_PROPERTY = "javadoc.args";
/*     */   public static final String PARSETAGS_PROPERTY = "javadoc.parsetags";
/*  69 */   private RootDoc mRootDoc = null;
/*  70 */   private JavadocTigerDelegate mTigerDelegate = null;
/*  71 */   private JavadocTagParser mTagParser = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean mParseTags = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(ElementContext paramElementContext) {
/*  83 */     if (paramElementContext == null) throw new IllegalArgumentException("null context"); 
/*  84 */     super.init(paramElementContext);
/*  85 */     getLogger().verbose("init()", this);
/*  86 */     initDelegate(paramElementContext);
/*  87 */     initJavadoc((JamServiceContext)paramElementContext);
/*     */   }
/*     */   
/*     */   public MClass build(String paramString1, String paramString2) {
/*     */     String[] arrayOfString;
/*  92 */     assertInitialized();
/*  93 */     if (getLogger().isVerbose(this)) {
/*  94 */       getLogger().verbose("trying to build '" + paramString1 + "' '" + paramString2 + "'");
/*     */     }
/*  96 */     String str = (paramString1.trim().length() > 0) ? (paramString1 + '.' + paramString2) : paramString2;
/*     */ 
/*     */     
/*  99 */     ClassDoc classDoc = this.mRootDoc.classNamed(str);
/* 100 */     if (classDoc == null) {
/* 101 */       if (getLogger().isVerbose(this)) {
/* 102 */         getLogger().verbose("no ClassDoc for " + str);
/*     */       }
/* 104 */       return null;
/*     */     } 
/* 106 */     ArrayList arrayList = null;
/*     */     
/* 108 */     ClassDoc[] arrayOfClassDoc = classDoc.importedClasses();
/* 109 */     if (arrayOfClassDoc != null) {
/* 110 */       arrayList = new ArrayList();
/* 111 */       for (byte b = 0; b < arrayOfClassDoc.length; b++) {
/* 112 */         arrayList.add(getFdFor((Type)arrayOfClassDoc[b]));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 117 */     PackageDoc[] arrayOfPackageDoc = classDoc.importedPackages();
/* 118 */     if (arrayOfPackageDoc != null) {
/* 119 */       if (arrayList == null) arrayList = new ArrayList(); 
/* 120 */       for (byte b = 0; b < arrayOfPackageDoc.length; b++) {
/* 121 */         arrayList.add(arrayOfPackageDoc[b].name() + ".*");
/*     */       }
/*     */     } 
/*     */     
/* 125 */     arrayOfPackageDoc = null;
/* 126 */     if (arrayList != null) {
/* 127 */       arrayOfString = new String[arrayList.size()];
/* 128 */       arrayList.toArray(arrayOfString);
/*     */     } 
/* 130 */     MClass mClass = createClassToBuild(paramString1, paramString2, arrayOfString, this);
/* 131 */     mClass.setArtifact(classDoc);
/* 132 */     return mClass;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void populate(MClass paramMClass) {
/* 139 */     if (paramMClass == null) throw new IllegalArgumentException("null dest"); 
/* 140 */     assertInitialized();
/* 141 */     ClassDoc classDoc1 = (ClassDoc)paramMClass.getArtifact();
/* 142 */     if (classDoc1 == null) throw new IllegalStateException("null artifact"); 
/* 143 */     paramMClass.setModifiers(classDoc1.modifierSpecifier());
/* 144 */     paramMClass.setIsInterface(classDoc1.isInterface());
/* 145 */     if (this.mTigerDelegate != null) paramMClass.setIsEnumType(this.mTigerDelegate.isEnum(classDoc1));
/*     */     
/* 147 */     ClassDoc classDoc2 = classDoc1.superclass();
/* 148 */     if (classDoc2 != null) paramMClass.setSuperclass(getFdFor((Type)classDoc2));
/*     */     
/* 150 */     ClassDoc[] arrayOfClassDoc1 = classDoc1.interfaces();
/* 151 */     for (byte b1 = 0; b1 < arrayOfClassDoc1.length; b1++) {
/* 152 */       paramMClass.addInterface(getFdFor((Type)arrayOfClassDoc1[b1]));
/*     */     }
/*     */     
/* 155 */     FieldDoc[] arrayOfFieldDoc = classDoc1.fields();
/* 156 */     for (byte b2 = 0; b2 < arrayOfFieldDoc.length; ) { populate(paramMClass.addNewField(), arrayOfFieldDoc[b2]); b2++; }
/*     */     
/* 158 */     ConstructorDoc[] arrayOfConstructorDoc = classDoc1.constructors();
/* 159 */     for (byte b3 = 0; b3 < arrayOfConstructorDoc.length; ) { populate((MInvokable)paramMClass.addNewConstructor(), (ExecutableMemberDoc)arrayOfConstructorDoc[b3]); b3++; }
/*     */     
/* 161 */     MethodDoc[] arrayOfMethodDoc = classDoc1.methods();
/* 162 */     for (byte b4 = 0; b4 < arrayOfMethodDoc.length; ) { populate(paramMClass.addNewMethod(), arrayOfMethodDoc[b4]); b4++; }
/*     */ 
/*     */ 
/*     */     
/* 166 */     if (this.mTigerDelegate != null) {
/* 167 */       this.mTigerDelegate.populateAnnotationTypeIfNecessary(classDoc1, paramMClass, this);
/*     */     }
/*     */ 
/*     */     
/* 171 */     addAnnotations((MAnnotatedElement)paramMClass, (ProgramElementDoc)classDoc1);
/*     */     
/* 173 */     addSourcePosition((MElement)paramMClass, (Doc)classDoc1);
/*     */     
/* 175 */     ClassDoc[] arrayOfClassDoc2 = classDoc1.innerClasses();
/* 176 */     if (arrayOfClassDoc2 != null) {
/* 177 */       for (byte b = 0; b < arrayOfClassDoc2.length; b++) {
/* 178 */         MClass mClass = paramMClass.addNewInnerClass(arrayOfClassDoc2[b].typeName());
/* 179 */         mClass.setArtifact(arrayOfClassDoc2[b]);
/* 180 */         populate(mClass);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MMethod addMethod(MClass paramMClass, MethodDoc paramMethodDoc) {
/* 188 */     MMethod mMethod = paramMClass.addNewMethod();
/* 189 */     populate(mMethod, paramMethodDoc);
/* 190 */     return mMethod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initDelegate(ElementContext paramElementContext) {
/* 197 */     this.mTigerDelegate = JavadocTigerDelegate.create(paramElementContext);
/*     */   }
/*     */   
/*     */   private void initJavadoc(JamServiceContext paramJamServiceContext) {
/*     */     File[] arrayOfFile;
/* 202 */     this.mTagParser = paramJamServiceContext.getTagParser();
/* 203 */     String str1 = paramJamServiceContext.getProperty("javadoc.parsetags");
/* 204 */     if (str1 != null) {
/* 205 */       this.mParseTags = Boolean.valueOf(str1).booleanValue();
/* 206 */       getLogger().verbose("mParseTags=" + this.mParseTags, this);
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 211 */       arrayOfFile = paramJamServiceContext.getSourceFiles();
/* 212 */     } catch (IOException iOException) {
/* 213 */       getLogger().error(iOException);
/*     */       return;
/*     */     } 
/* 216 */     if (arrayOfFile == null || arrayOfFile.length == 0) {
/* 217 */       throw new IllegalArgumentException("No source files in context.");
/*     */     }
/* 219 */     String str2 = (paramJamServiceContext.getInputSourcepath() == null) ? null : paramJamServiceContext.getInputSourcepath().toString();
/*     */     
/* 221 */     String str3 = (paramJamServiceContext.getInputClasspath() == null) ? null : paramJamServiceContext.getInputClasspath().toString();
/*     */     
/* 223 */     if (getLogger().isVerbose(this)) {
/* 224 */       getLogger().verbose("sourcePath =" + str2);
/* 225 */       getLogger().verbose("classPath =" + str3);
/* 226 */       for (byte b = 0; b < arrayOfFile.length; b++) {
/* 227 */         getLogger().verbose("including '" + arrayOfFile[b] + "'");
/*     */       }
/*     */     } 
/* 230 */     JavadocRunner javadocRunner = JavadocRunner.newInstance();
/*     */     try {
/* 232 */       PrintWriter printWriter = null;
/* 233 */       if (getLogger().isVerbose(this)) {
/* 234 */         printWriter = new PrintWriter(System.out);
/*     */       }
/* 236 */       this.mRootDoc = javadocRunner.run(arrayOfFile, printWriter, str2, str3, getJavadocArgs(paramJamServiceContext), getLogger());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 242 */       if (this.mRootDoc == null) {
/* 243 */         getLogger().error("Javadoc returned a null root");
/*     */       } else {
/* 245 */         if (getLogger().isVerbose(this)) {
/* 246 */           getLogger().verbose(" received " + (this.mRootDoc.classes()).length + " ClassDocs from javadoc: ");
/*     */         }
/*     */         
/* 249 */         ClassDoc[] arrayOfClassDoc = this.mRootDoc.classes();
/*     */ 
/*     */ 
/*     */         
/* 253 */         for (byte b = 0; b < arrayOfClassDoc.length; b++) {
/* 254 */           if (arrayOfClassDoc[b].containingClass() == null) {
/* 255 */             if (getLogger().isVerbose(this)) {
/* 256 */               getLogger().verbose("..." + arrayOfClassDoc[b].qualifiedName());
/*     */             }
/* 258 */             ((JamServiceContextImpl)paramJamServiceContext).includeClass(getFdFor((Type)arrayOfClassDoc[b]));
/*     */           } 
/*     */         } 
/*     */       } 
/* 262 */     } catch (FileNotFoundException fileNotFoundException) {
/* 263 */       getLogger().error(fileNotFoundException);
/* 264 */     } catch (IOException iOException) {
/* 265 */       getLogger().error(iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void populate(MField paramMField, FieldDoc paramFieldDoc) {
/* 270 */     paramMField.setArtifact(paramFieldDoc);
/* 271 */     paramMField.setSimpleName(paramFieldDoc.name());
/* 272 */     paramMField.setType(getFdFor(paramFieldDoc.type()));
/* 273 */     paramMField.setModifiers(paramFieldDoc.modifierSpecifier());
/* 274 */     addAnnotations((MAnnotatedElement)paramMField, (ProgramElementDoc)paramFieldDoc);
/* 275 */     addSourcePosition((MElement)paramMField, (Doc)paramFieldDoc);
/*     */   }
/*     */   
/*     */   private void populate(MMethod paramMMethod, MethodDoc paramMethodDoc) {
/* 279 */     if (paramMMethod == null) throw new IllegalArgumentException("null dest"); 
/* 280 */     if (paramMethodDoc == null) throw new IllegalArgumentException("null src"); 
/* 281 */     populate((MInvokable)paramMMethod, (ExecutableMemberDoc)paramMethodDoc);
/* 282 */     paramMMethod.setReturnType(getFdFor(paramMethodDoc.returnType()));
/*     */   }
/*     */   
/*     */   private void populate(MInvokable paramMInvokable, ExecutableMemberDoc paramExecutableMemberDoc) {
/* 286 */     if (paramMInvokable == null) throw new IllegalArgumentException("null dest"); 
/* 287 */     if (paramExecutableMemberDoc == null) throw new IllegalArgumentException("null src"); 
/* 288 */     paramMInvokable.setArtifact(paramExecutableMemberDoc);
/* 289 */     paramMInvokable.setSimpleName(paramExecutableMemberDoc.name());
/* 290 */     paramMInvokable.setModifiers(paramExecutableMemberDoc.modifierSpecifier());
/* 291 */     ClassDoc[] arrayOfClassDoc = paramExecutableMemberDoc.thrownExceptions();
/* 292 */     for (byte b1 = 0; b1 < arrayOfClassDoc.length; b1++) {
/* 293 */       paramMInvokable.addException(getFdFor((Type)arrayOfClassDoc[b1]));
/*     */     }
/* 295 */     Parameter[] arrayOfParameter = paramExecutableMemberDoc.parameters();
/* 296 */     for (byte b2 = 0; b2 < arrayOfParameter.length; b2++) {
/* 297 */       populate(paramMInvokable.addNewParameter(), paramExecutableMemberDoc, arrayOfParameter[b2]);
/*     */     }
/* 299 */     addAnnotations((MAnnotatedElement)paramMInvokable, (ProgramElementDoc)paramExecutableMemberDoc);
/* 300 */     addSourcePosition((MElement)paramMInvokable, (Doc)paramExecutableMemberDoc);
/*     */   }
/*     */   
/*     */   private void populate(MParameter paramMParameter, ExecutableMemberDoc paramExecutableMemberDoc, Parameter paramParameter) {
/* 304 */     paramMParameter.setArtifact(paramParameter);
/* 305 */     paramMParameter.setSimpleName(paramParameter.name());
/* 306 */     paramMParameter.setType(getFdFor(paramParameter.type()));
/* 307 */     if (this.mTigerDelegate != null) this.mTigerDelegate.extractAnnotations((MAnnotatedElement)paramMParameter, paramExecutableMemberDoc, paramParameter);
/*     */   
/*     */   }
/*     */   
/*     */   private String[] getJavadocArgs(JamServiceContext paramJamServiceContext) {
/* 312 */     String str = paramJamServiceContext.getProperty("javadoc.args");
/* 313 */     if (str == null) return null; 
/* 314 */     StringTokenizer stringTokenizer = new StringTokenizer(str);
/* 315 */     String[] arrayOfString = new String[stringTokenizer.countTokens()];
/* 316 */     byte b = 0;
/* 317 */     for (; stringTokenizer.hasMoreTokens(); arrayOfString[b++] = stringTokenizer.nextToken());
/* 318 */     return arrayOfString;
/*     */   }
/*     */   
/*     */   private void addAnnotations(MAnnotatedElement paramMAnnotatedElement, ProgramElementDoc paramProgramElementDoc) {
/* 322 */     String str = paramProgramElementDoc.commentText();
/* 323 */     if (str != null) paramMAnnotatedElement.createComment().setText(str); 
/* 324 */     Tag[] arrayOfTag = paramProgramElementDoc.tags();
/*     */ 
/*     */ 
/*     */     
/* 328 */     for (byte b = 0; b < arrayOfTag.length; b++) {
/* 329 */       if (getLogger().isVerbose(this)) {
/* 330 */         getLogger().verbose("...'" + arrayOfTag[b].name() + "' ' " + arrayOfTag[b].text());
/*     */       }
/*     */       
/* 333 */       this.mTagParser.parse(paramMAnnotatedElement, arrayOfTag[b]);
/*     */     } 
/* 335 */     if (this.mTigerDelegate != null) this.mTigerDelegate.extractAnnotations(paramMAnnotatedElement, paramProgramElementDoc);
/*     */   
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
/*     */   public static String getFdFor(Type paramType) {
/* 348 */     if (paramType == null) throw new IllegalArgumentException("null type"); 
/* 349 */     String str1 = paramType.dimension();
/* 350 */     if (str1 == null || str1.length() == 0) {
/* 351 */       ClassDoc classDoc = paramType.asClassDoc();
/* 352 */       if (classDoc != null) {
/* 353 */         ClassDoc classDoc1 = classDoc.containingClass();
/* 354 */         if (classDoc1 == null) return classDoc.qualifiedName(); 
/* 355 */         String str = classDoc.name();
/* 356 */         str = str.substring(str.lastIndexOf('.') + 1);
/* 357 */         return classDoc1.qualifiedName() + '$' + str;
/*     */       } 
/* 359 */       return paramType.qualifiedTypeName();
/*     */     } 
/*     */     
/* 362 */     StringWriter stringWriter = new StringWriter(); byte b; int i;
/* 363 */     for (b = 0, i = str1.length() / 2; b < i; ) { stringWriter.write("["); b++; }
/* 364 */      String str2 = PrimitiveClassImpl.getPrimitiveClassForName(paramType.qualifiedTypeName());
/*     */     
/* 366 */     if (str2 != null) {
/* 367 */       stringWriter.write(str2);
/*     */     } else {
/* 369 */       stringWriter.write("L");
/* 370 */       if (paramType.asClassDoc() != null) {
/* 371 */         stringWriter.write(paramType.asClassDoc().qualifiedName());
/*     */       } else {
/* 373 */         stringWriter.write(paramType.qualifiedTypeName());
/*     */       } 
/* 375 */       stringWriter.write(";");
/*     */     } 
/* 377 */     return stringWriter.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addSourcePosition(MElement paramMElement, Doc paramDoc) {
/* 382 */     SourcePosition sourcePosition = paramDoc.position();
/* 383 */     if (sourcePosition != null) addSourcePosition(paramMElement, sourcePosition); 
/*     */   }
/*     */   
/*     */   public static void addSourcePosition(MElement paramMElement, SourcePosition paramSourcePosition) {
/* 387 */     MSourcePosition mSourcePosition = paramMElement.createSourcePosition();
/* 388 */     mSourcePosition.setColumn(paramSourcePosition.column());
/* 389 */     mSourcePosition.setLine(paramSourcePosition.line());
/* 390 */     File file = paramSourcePosition.file();
/* 391 */     if (file != null) mSourcePosition.setSourceURI(file.toURI()); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\javadoc\JavadocClassBuilder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */