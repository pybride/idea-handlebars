/* The following code was generated by JFlex 1.4.3 on 2/20/12 11:37 AM */

// This is the official Handlebars lexer definition:
// (taken from the following revision: https://github.com/wycats/handlebars.js/blob/932e2970ad29b16d6d6874ad0bfb44b07b4cd765/src/handlebars.l)
// We base our lexer directly on that, making some modifications to account for Jison/JFlex syntax and functionality differences
// TODO there is a later commit which adds support for "escaped mustaches" here: https://github.com/wycats/handlebars.js/blob/c79c761460f7d08e3862c0c9992f65a799771851/src/handlebars.l
//
//
//%x mu
//
//%%
//
//[^\x00]*?/("{{")                 { this.begin("mu"); if (yytext) return 'CONTENT'; }
//[^\x00]+                         { return 'CONTENT'; }
//
//<mu>"{{>"                        { return 'OPEN_PARTIAL'; }
//<mu>"{{#"                        { return 'OPEN_BLOCK'; }
//<mu>"{{/"                        { return 'OPEN_ENDBLOCK'; }
//<mu>"{{^"                        { return 'OPEN_INVERSE'; }
//<mu>"{{"\s*"else"                { return 'OPEN_INVERSE'; }
//<mu>"{{{"                        { return 'OPEN_UNESCAPED'; }
//<mu>"{{&"                        { return 'OPEN_UNESCAPED'; }
//<mu>"{{!"[\s\S]*?"}}"            { yytext = yytext.substr(3,yyleng-5); this.begin("INITIAL"); return 'COMMENT'; }
//<mu>"{{"                         { return 'OPEN'; }
//
//<mu>"="                          { return 'EQUALS'; }
//<mu>"."/[} ]                     { return 'ID'; }
//<mu>".."                         { return 'ID'; }
//<mu>[\/.]                        { return 'SEP'; }
//<mu>\s+                          { /*ignore whitespace*/ }
//<mu>"}}}"                        { this.begin("INITIAL"); return 'CLOSE'; }
//<mu>"}}"                         { this.begin("INITIAL"); return 'CLOSE'; }
//<mu>'"'("\\"["]|[^"])*'"'        { yytext = yytext.substr(1,yyleng-2).replace(/\\"/g,'"'); return 'STRING'; }
//<mu>"true"/[}\s]                 { return 'BOOLEAN'; }
//<mu>"false"/[}\s]                { return 'BOOLEAN'; }
//<mu>[0-9]+/[}\s]                 { return 'INTEGER'; }
//<mu>[a-zA-Z0-9_$-]+/[=}\s\/.]    { return 'ID'; }
//<mu>\[[^\]]*\]                   { yytext = yytext.substr(1, yyleng-2); return 'ID'; }
//<mu>.                            { return 'INVALID'; }
//
//<INITIAL,mu><<EOF>>              { return 'EOF'; }

package com.dmarcotte.handlebars.parsing;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.Stack;
import com.dmarcotte.handlebars.parsing.HbTokenTypes;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 2/20/12 11:37 AM from the specification file
 * <tt>handlebars.flex</tt>
 */
final class _HbLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int mu = 2;
  public static final int emu = 4;
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\1\10\10\0\1\1\1\2\1\3\1\1\1\1\22\0\1\1\1\22"+
    "\1\24\1\13\1\33\1\0\1\21\1\0\2\11\2\0\1\0\1\33"+
    "\1\4\1\14\2\6\1\6\7\6\3\0\1\23\1\12\2\0\32\33"+
    "\1\34\1\25\1\35\1\15\1\33\1\0\1\32\3\33\1\16\1\31"+
    "\5\33\1\17\5\33\1\27\1\20\1\26\1\30\5\33\1\5\1\0"+
    "\1\7\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\0\1\2\2\3\1\1\1\4\3\3"+
    "\1\4\1\3\1\5\4\3\1\1\1\0\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\2\0\1\14\1\0\1\15"+
    "\5\0\1\16\1\17\1\20\1\21\1\22\2\0\1\14"+
    "\7\0\1\23\1\24\1\0\1\25";

  private static int [] zzUnpackAction() {
    int [] result = new int[55];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\36\0\74\0\132\0\170\0\226\0\264\0\322"+
    "\0\360\0\u010e\0\u012c\0\226\0\u014a\0\226\0\u0168\0\u0186"+
    "\0\u01a4\0\u01c2\0\u01e0\0\170\0\226\0\226\0\226\0\u01fe"+
    "\0\226\0\226\0\u010e\0\u014a\0\u021c\0\u0168\0\226\0\u023a"+
    "\0\u0258\0\u0276\0\u01c2\0\u0294\0\226\0\226\0\226\0\226"+
    "\0\226\0\u02b2\0\u02d0\0\226\0\u02ee\0\u030c\0\u032a\0\u0348"+
    "\0\u0366\0\u0384\0\u03a2\0\u0348\0\226\0\u03c0\0\226";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[55];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\5\4\1\5\2\4\2\6\24\4\1\6\3\7\1\10"+
    "\1\11\1\12\1\13\4\6\1\14\1\6\3\15\2\6"+
    "\1\16\1\17\1\6\1\20\2\15\1\21\2\15\1\22"+
    "\2\6\2\23\33\6\5\4\1\24\2\4\2\0\24\4"+
    "\5\0\1\25\67\0\3\7\33\0\3\26\1\27\2\0"+
    "\1\26\33\0\1\30\31\0\3\31\1\32\1\0\1\33"+
    "\1\31\4\0\1\32\1\0\3\34\2\0\1\32\2\0"+
    "\6\34\11\0\1\35\27\0\4\32\1\0\1\34\1\32"+
    "\4\0\1\32\1\0\3\34\2\0\1\32\2\0\6\34"+
    "\2\0\24\36\1\37\1\40\10\36\1\0\4\32\1\0"+
    "\1\34\1\32\4\0\1\32\1\0\3\34\2\0\1\32"+
    "\2\0\1\34\1\41\4\34\3\0\4\32\1\0\1\34"+
    "\1\32\4\0\1\32\1\0\3\34\2\0\1\32\2\0"+
    "\4\34\1\42\1\34\2\0\35\43\1\27\1\0\2\23"+
    "\34\0\3\44\1\0\1\45\4\0\1\46\1\47\1\50"+
    "\1\51\1\52\2\0\1\45\1\53\22\0\1\54\26\0"+
    "\2\36\1\0\33\36\1\0\4\32\1\0\1\34\1\32"+
    "\4\0\1\32\1\0\3\34\2\0\1\32\2\0\2\34"+
    "\1\55\3\34\3\0\4\32\1\0\1\34\1\32\4\0"+
    "\1\32\1\0\1\34\1\56\1\34\2\0\1\32\2\0"+
    "\6\34\3\0\3\44\12\0\1\52\36\0\1\57\16\0"+
    "\5\53\1\0\1\53\1\60\1\53\1\0\24\53\1\0"+
    "\4\32\1\0\1\34\1\32\4\0\1\32\1\0\1\61"+
    "\2\34\2\0\1\32\2\0\6\34\3\0\4\32\1\0"+
    "\1\34\1\32\4\0\1\32\1\0\2\34\1\62\2\0"+
    "\1\32\2\0\6\34\22\0\1\63\15\0\5\53\1\0"+
    "\1\53\1\64\1\53\1\0\24\53\1\0\3\65\1\32"+
    "\1\0\1\34\1\65\4\0\1\32\1\0\3\34\2\0"+
    "\1\32\2\0\6\34\3\0\4\32\1\0\1\34\1\32"+
    "\4\0\1\32\1\0\1\66\2\34\2\0\1\32\2\0"+
    "\6\34\20\0\1\51\20\0\3\67\1\32\1\0\1\34"+
    "\1\67\4\0\1\32\1\0\3\34\2\0\1\32\2\0"+
    "\6\34\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[990];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\1\1\0\2\1\1\11\5\1\1\11\1\1"+
    "\1\11\5\1\1\0\3\11\1\1\2\11\2\0\1\1"+
    "\1\0\1\11\5\0\5\11\2\0\1\11\7\0\1\1"+
    "\1\11\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[55];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    private Stack<Integer> stack = new Stack<Integer>();

    public void yypushState(int newState) {
      stack.push(yystate());
      yybegin(newState);
    }

    public void yypopState() {
      yybegin(stack.pop());
    }


  _HbLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  _HbLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 104) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL.charAt(zzCurrentPosL++);
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL.charAt(zzCurrentPosL++);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 1: 
          { return HbTokenTypes.WHITE_SPACE;
          }
        case 22: break;
        case 21: 
          // lookahead expression with fixed base length
          zzMarkedPos = zzStartRead + 5;
          { return HbTokenTypes.BOOLEAN;
          }
        case 23: break;
        case 20: 
          // lookahead expression with fixed base length
          zzMarkedPos = zzStartRead + 4;
          { return HbTokenTypes.BOOLEAN;
          }
        case 24: break;
        case 15: 
          { return HbTokenTypes.OPEN_PARTIAL;
          }
        case 25: break;
        case 4: 
          { return HbTokenTypes.SEP;
          }
        case 26: break;
        case 8: 
          { return HbTokenTypes.ID;
          }
        case 27: break;
        case 7: 
          // lookahead expression with fixed base length
          zzMarkedPos = zzStartRead + 1;
          { return HbTokenTypes.ID;
          }
        case 28: break;
        case 11: 
          // lookahead expression with fixed lookahead length
          yypushback(1);
          { return HbTokenTypes.ID;
          }
        case 29: break;
        case 9: 
          { return HbTokenTypes.OPEN;
          }
        case 30: break;
        case 17: 
          { return HbTokenTypes.OPEN_ENDBLOCK;
          }
        case 31: break;
        case 18: 
          { return HbTokenTypes.OPEN_INVERSE;
          }
        case 32: break;
        case 13: 
          { return HbTokenTypes.STRING;
          }
        case 33: break;
        case 19: 
          { yypopState(); return HbTokenTypes.COMMENT;
          }
        case 34: break;
        case 16: 
          { return HbTokenTypes.OPEN_BLOCK;
          }
        case 35: break;
        case 6: 
          { yypushback(2);
            yypushState(mu); if (!yytext().toString().equals("")) return HbTokenTypes.CONTENT;
          }
        case 36: break;
        case 2: 
          { return HbTokenTypes.CONTENT;
          }
        case 37: break;
        case 5: 
          { return HbTokenTypes.EQUALS;
          }
        case 38: break;
        case 14: 
          { return HbTokenTypes.OPEN_UNESCAPED;
          }
        case 39: break;
        case 12: 
          { yypopState(); return HbTokenTypes.CLOSE;
          }
        case 40: break;
        case 3: 
          { return HbTokenTypes.INVALID;
          }
        case 41: break;
        case 10: 
          // lookahead expression with fixed lookahead length
          yypushback(1);
          { return HbTokenTypes.INTEGER;
          }
        case 42: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
