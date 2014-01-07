%!PS-Adobe-3.0
%%Title: Callback.java, Linda.java, TupleFormatException.java, Tuple.java, linda.ps
%%For: 'Glinel-mortreuil Quentin'
%%Creator: a2ps version 4.14
%%CreationDate: Thu Jan 17 09:52:40 2013
%%BoundingBox: 24 50 571 792
%%DocumentData: Clean7Bit
%%Orientation: Landscape
%%Pages: 5
%%PageOrder: Ascend
%%DocumentMedia: A4 595 842 0 () ()
%%DocumentNeededResources: font Courier
%%+ font Courier-Bold
%%+ font Courier-BoldOblique
%%+ font Courier-Oblique
%%+ font Helvetica
%%+ font Helvetica-Bold
%%+ font Symbol
%%+ font Times-Bold
%%+ font Times-Roman
%%DocumentProcessColors: Black 
%%Requirements: Tumble Duplex 
%%DocumentSuppliedResources: procset a2ps-a2ps-hdr
%%+ procset a2ps-black+white-Prolog
%%+ encoding ISO-8859-1Encoding
%%EndComments
/a2psdict 200 dict def
a2psdict begin
%%BeginProlog
%%Copyright: (c) 1988, 89, 90, 91, 92, 93 Miguel Santana
%%Copyright: (c) 1995, 96, 97, 98 Akim Demaille, Miguel Santana
% Check PostScript language level.
/languagelevel where {
  pop /gs_languagelevel languagelevel def
} {
  /gs_languagelevel 1 def
} ifelse

% EPSF import as in the Red Book
/BeginInclude {
  /b4_Inc_state save def    		% Save state for cleanup
  /dict_count countdictstack def	% Count objects on dict stack
  /op_count count 1 sub def		% Count objects on operand stack 
  userdict begin
    0 setgray 0 setlinecap
    1 setlinewidth 0 setlinejoin
    10 setmiterlimit [ ] 0 setdash newpath
    gs_languagelevel 1 ne {
      false setstrokeadjust false setoverprint 
    } if
} bind def

/EndInclude {
  count op_count sub { pos } repeat	% Clean up stacks
  countdictstack dict_count sub { end } repeat
  b4_Inc_state restore
} bind def

/BeginEPSF {
  BeginInclude
  /showpage { } def
} bind def

/EndEPSF {
  EndInclude
} bind def

% Page prefeed
/page_prefeed {         % bool -> -
  statusdict /prefeed known {
    statusdict exch /prefeed exch put
  } {
    pop
  } ifelse
} bind def

/deffont {
  findfont exch scalefont def
} bind def

/reencode_font {
  findfont reencode 2 copy definefont pop def
} bind def

% Function c-show (str => -)
% centers text only according to x axis.
/c-show { 
  dup stringwidth pop
  2 div neg 0 rmoveto
  show
} bind def

% Function l-show (str => -)
% prints texts so that it ends at currentpoint
/l-show {
  dup stringwidth pop neg 
  0 
  rmoveto show
} bind def

% center-fit show (str w => -)
% show centered, and scale currentfont so that the width is less than w
/cfshow {
  exch dup stringwidth pop
  % If the title is too big, try to make it smaller
  3 2 roll 2 copy
  gt
  { % if, i.e. too big
    exch div
    currentfont exch scalefont setfont
  } { % ifelse
    pop pop 
  }
  ifelse
  c-show			% center title
} bind def

% Return the y size of the current font
% - => fontsize
/currentfontsize {
  currentfont /FontType get 0 eq {
    currentfont /FontMatrix get 3 get
  }{
    currentfont /FontMatrix get 3 get 1000 mul
  } ifelse
} bind def

% reencode the font
% <encoding-vector> <fontdict> -> <newfontdict>
/reencode { %def
  dup length 5 add dict begin
    { %forall
      % <vector> <key> <val>
      1 index /FID ne 
      { def }{ pop pop } ifelse
    } forall
    /Encoding exch def % -

    % Use the font's bounding box to determine the ascent, descent,
    % and overall height; don't forget that these values have to be
    % transformed using the font's matrix.
    % We use `load' because sometimes BBox is executable, sometimes not.
    % Since we need 4 numbers an not an array avoid BBox from being executed
    /FontBBox load aload pop
    FontMatrix transform /Ascent exch def pop
    FontMatrix transform /Descent exch def pop
    /FontHeight Ascent Descent sub def

    % Get the underline position and thickness if they're defined.
    % Use 1 if they are not defined.
    currentdict /FontInfo 2 copy known
    { get
      /UnderlinePosition 2 copy % <FontInfo> /UP <FontInfo> /UP
      2 copy known
      { get }{ pop pop 1 } ifelse
      0 exch FontMatrix transform exch pop
      def % <FontInfo>

      /UnderlineThickness 2 copy % <FontInfo> /UT <FontInfo> /UT
      2 copy known
      { get }{ pop pop 1 } ifelse
      0 exch FontMatrix transform exch pop
      def % <FontInfo>
      pop % -
    }{ pop pop
    } ifelse

    currentdict
  end 
} bind def

% composite fonts for ASCII-EUC mixed strings
% Version 1.2 1/31/1990
% Original Ken'ichi HANDA (handa@etl.go.jp)
% Modified Norio Katayama (katayama@rd.nacsis.ac.jp),1998
% Extend & Fix Koji Nakamaru (maru@on.cs.keio.ac.jp), 1999
% Anyone can freely copy, modify, distribute this program.

/copyfont {	% font-dic extra-entry-count  copyfont  font-dic
	1 index maxlength add dict begin
	{	1 index /FID ne 2 index /UniqueID ne and
		{def} {pop pop} ifelse
	} forall
	currentdict
	end
} bind def

/compositefont { % ASCIIFontName EUCFontName RomanScale RomanOffset Rot(T/F) compositefont font
    /RomanRotation exch def
    /RomanOffset exch def
    /RomanScale exch def
    userdict /fixeucfont_dict known not {
	userdict begin
	    /fixeucfont_dict 2 dict begin
		/UpperByteEncoding [
		    16#00 1 16#20 { pop 0 } for
		    16#21 1 16#28 { 16#20 sub } for
		    16#29 1 16#2F { pop 0 } for
		    16#30 1 16#74 { 16#27 sub } for
		    16#75 1 16#FF { pop 0 } for
		] def
	        /LowerByteEncoding [
		    16#00 1 16#A0 { pop /.notdef } for
		    16#A1 1 16#FE { 16#80 sub 16 2 string cvrs
				    (cXX) dup 1 4 -1 roll
				    putinterval cvn } for
		    /.notdef
		] def
		currentdict
	    end def
	end
    } if
    findfont dup /FontType get 0 eq {
	14 dict begin
	    %
	    % 7+8 bit EUC font
	    %
	    12 dict begin
		/EUCFont exch def
		/FontInfo (7+8 bit EUC font) readonly def
		/PaintType 0 def
		/FontType 0 def
		/FontMatrix matrix def
		% /FontName
		/Encoding fixeucfont_dict /UpperByteEncoding get def
		/FMapType 2 def
		EUCFont /WMode known
		{ EUCFont /WMode get /WMode exch def }
		{ /WMode 0 def } ifelse
		/FDepVector [
		    EUCFont /FDepVector get 0 get
		    [ 16#21 1 16#28 {} for 16#30 1 16#74 {} for ]
		    {
			13 dict begin
			    /EUCFont EUCFont def
			    /UpperByte exch 16#80 add def	
			    % /FontName
			    /FontInfo (EUC lower byte font) readonly def
			    /PaintType 0 def
			    /FontType 3 def
			    /FontMatrix matrix def
			    /FontBBox {0 0 0 0} def
			    /Encoding
				fixeucfont_dict /LowerByteEncoding get def
			    % /UniqueID
			    % /WMode
			    /BuildChar {
				gsave
				exch dup /EUCFont get setfont
				/UpperByte get
				2 string
				dup 0 4 -1 roll put
				dup 1 4 -1 roll put
				dup stringwidth setcharwidth
				0 0 moveto show
				grestore
			    } bind def
			    currentdict
			end
			/lowerbytefont exch definefont
		    } forall
		] def
		currentdict
	    end
	    /eucfont exch definefont
	    exch
	    findfont 1 copyfont dup begin
		RomanRotation {
			/FontMatrix FontMatrix
			[ 0 RomanScale neg RomanScale 0 RomanOffset neg 0 ]
			matrix concatmatrix def
		}{
			/FontMatrix FontMatrix
			[ RomanScale 0 0 RomanScale 0 RomanOffset ] matrix concatmatrix
			def
			/CDevProc
			    {pop pop pop pop 0 exch -1000 exch 2 div 880} def
		} ifelse
	    end
	    /asciifont exch definefont
	    exch
	    /FDepVector [ 4 2 roll ] def
	    /FontType 0 def
	    /WMode 0 def
	    /FMapType 4 def
	    /FontMatrix matrix def
	    /Encoding [0 1] def
	    /FontBBox {0 0 0 0} def
%	    /FontHeight 1.0 def % XXXX
	    /FontHeight RomanScale 1.0 ge { RomanScale }{ 1.0 } ifelse def
	    /Descent -0.3 def   % XXXX
	    currentdict
	end
	/tmpfont exch definefont
	pop
	/tmpfont findfont
    }{
	pop findfont 0 copyfont
    } ifelse
} def	

/slantfont {	% FontName slant-degree  slantfont  font'
    exch findfont 1 copyfont begin
    [ 1 0 4 -1 roll 1 0 0 ] FontMatrix exch matrix concatmatrix
    /FontMatrix exch def
    currentdict
    end
} def

% Function print line number (<string> # -)
/# {
  gsave
    sx cw mul neg 2 div 0 rmoveto
    f# setfont
    c-show
  grestore
} bind def

% -------- Some routines to enlight plain b/w printings ---------

% Underline
% width --
/dounderline {
  currentpoint
  gsave
    moveto
    0 currentfont /Descent get currentfontsize mul rmoveto
    0 rlineto
    stroke
  grestore
} bind def

% Underline a string
% string --
/dounderlinestring {
  stringwidth pop
  dounderline
} bind def

/UL {
  /ul exch store
} bind def

% Draw a box of WIDTH wrt current font
% width --
/dobox {
  currentpoint
  gsave
    newpath
    moveto
    0 currentfont /Descent get currentfontsize mul rmoveto
    dup 0 rlineto
    0 currentfont /FontHeight get currentfontsize mul rlineto
    neg 0 rlineto
    closepath
    stroke
  grestore
} bind def

/BX {
  /bx exch store
} bind def

% Box a string
% string --
/doboxstring {
  stringwidth pop
  dobox
} bind def

%
% ------------- Color routines ---------------
%
/FG /setrgbcolor load def

% Draw the background
% width --
/dobackground {
  currentpoint
  gsave
    newpath
    moveto
    0 currentfont /Descent get currentfontsize mul rmoveto
    dup 0 rlineto
    0 currentfont /FontHeight get currentfontsize mul rlineto
    neg 0 rlineto
    closepath
    bgcolor aload pop setrgbcolor
    fill
  grestore
} bind def

% Draw bg for a string
% string --
/dobackgroundstring {
  stringwidth pop
  dobackground
} bind def


/BG {
  dup /bg exch store
  { mark 4 1 roll ] /bgcolor exch store } if
} bind def


/Show {
  bg { dup dobackgroundstring } if
  ul { dup dounderlinestring } if
  bx { dup doboxstring } if
  show
} bind def

% Function T(ab), jumps to the n-th tabulation in the current line
/T {
  cw mul x0 add
  bg { dup currentpoint pop sub dobackground } if
  ul { dup currentpoint pop sub dounderline } if
  bx { dup currentpoint pop sub dobox } if
  y0 moveto
} bind def

% Function n: move to the next line
/n {
  /y0 y0 bfs sub store
  x0 y0 moveto
} bind def

% Function N: show and move to the next line
/N {
  Show
  /y0 y0 bfs sub store
  x0 y0 moveto
} bind def

/S {
  Show
} bind def

%%BeginResource: procset a2ps-a2ps-hdr 2.0 2
%%Copyright: (c) 1988, 89, 90, 91, 92, 93 Miguel Santana
%%Copyright: (c) 1995, 96, 97, 98 Akim Demaille, Miguel Santana
% Function title: prints page header.
% <ct> <rt> <lt> are passed as argument
/title { 
  % 1. Draw the background
  x v get y v get moveto
  gsave
    0 th 2 div neg rmoveto 
    th setlinewidth
    0.95 setgray
    pw 0 rlineto stroke
  grestore
  % 2. Border it
  gsave
    0.7 setlinewidth
    pw 0 rlineto
    0 th neg rlineto
    pw neg 0 rlineto
    closepath stroke
  grestore
  % stk: ct rt lt
  x v get y v get th sub 1 add moveto
%%IncludeResource: font Helvetica
  fHelvetica fnfs 0.8 mul scalefont setfont
  % 3. The left title
  gsave
    dup stringwidth pop fnfs 0.8 mul add exch % leave space took on stack
    fnfs 0.8 mul hm rmoveto
    show			% left title
  grestore
  exch
  % stk: ct ltw rt
  % 4. the right title
  gsave
    dup stringwidth pop fnfs 0.8 mul add exch % leave space took on stack
    dup
    pw exch stringwidth pop fnfs 0.8 mul add sub
    hm
    rmoveto
    show			% right title
  grestore
  % stk: ct ltw rtw
  % 5. the center title
  gsave
    pw 3 1 roll
    % stk: ct pw ltw rtw
    3 copy 
    % Move to the center of the left room
    sub add 2 div hm rmoveto
    % What is the available space in here?
    add sub fnfs 0.8 mul sub fnfs 0.8 mul sub
    % stk: ct space_left
%%IncludeResource: font Helvetica-Bold
  fHelvetica-Bold fnfs scalefont setfont
    cfshow
  grestore
} bind def

% Function border: prints virtual page border
/border { %def
  gsave				% print four sides
    0 setgray
    x v get y v get moveto
    0.7 setlinewidth		% of the square
    pw 0 rlineto
    0 ph neg rlineto
    pw neg 0 rlineto
    closepath stroke
  grestore
} bind def

% Function water: prints a water mark in background
/water { %def
  gsave
    scx scy moveto rotate
%%IncludeResource: font Times-Bold
  fTimes-Bold 100 scalefont setfont
    .97 setgray
    dup stringwidth pop 2 div neg -50 rmoveto
    show
  grestore
} bind def

% Function rhead: prints the right header
/rhead {  %def
  lx ly moveto
  fHelvetica fnfs 0.8 mul scalefont setfont
  l-show
} bind def

% Function footer (cf rf lf -> -)
/footer {
  fHelvetica fnfs 0.8 mul scalefont setfont
  dx dy moveto
  show

  snx sny moveto
  l-show
  
  fnx fny moveto
  c-show
} bind def
%%EndResource
%%BeginResource: procset a2ps-black+white-Prolog 2.0 1

% Function T(ab), jumps to the n-th tabulation in the current line
/T { 
  cw mul x0 add y0 moveto
} bind def

% Function n: move to the next line
/n { %def
  /y0 y0 bfs sub store
  x0 y0 moveto
} bind def

% Function N: show and move to the next line
/N {
  Show
  /y0 y0 bfs sub store
  x0 y0 moveto
}  bind def

/S {
  Show
} bind def

/p {
  false UL
  false BX
  fCourier bfs scalefont setfont
  Show
} bind def

/sy {
  false UL
  false BX
  fSymbol bfs scalefont setfont
  Show
} bind def

/k {
  false UL
  false BX
  fCourier-Oblique bfs scalefont setfont
  Show
} bind def

/K {
  false UL
  false BX
  fCourier-Bold bfs scalefont setfont
  Show
} bind def

/c {
  false UL
  false BX
  fCourier-Oblique bfs scalefont setfont
  Show
} bind def

/C {
  false UL
  false BX
  fCourier-BoldOblique bfs scalefont setfont
  Show 
} bind def

/l {
  false UL
  false BX
  fHelvetica bfs scalefont setfont
  Show
} bind def

/L {
  false UL
  false BX
  fHelvetica-Bold bfs scalefont setfont
  Show 
} bind def

/str{
  false UL
  false BX
  fTimes-Roman bfs scalefont setfont
  Show
} bind def

/e{
  false UL
  true BX
  fHelvetica-Bold bfs scalefont setfont
  Show
} bind def

%%EndResource
%%EndProlog
%%BeginSetup
%%IncludeResource: font Courier
%%IncludeResource: font Courier-Oblique
%%IncludeResource: font Courier-Bold
%%IncludeResource: font Times-Roman
%%IncludeResource: font Symbol
%%IncludeResource: font Courier-BoldOblique
%%BeginResource: encoding ISO-8859-1Encoding
/ISO-8859-1Encoding [
/.notdef /.notdef /.notdef /.notdef /.notdef /.notdef /.notdef /.notdef 
/.notdef /.notdef /.notdef /.notdef /.notdef /.notdef /.notdef /.notdef 
/.notdef /.notdef /.notdef /.notdef /.notdef /.notdef /.notdef /.notdef 
/.notdef /.notdef /.notdef /.notdef /.notdef /.notdef /.notdef /.notdef 
/space /exclam /quotedbl /numbersign /dollar /percent /ampersand /quoteright 
/parenleft /parenright /asterisk /plus /comma /minus /period /slash 
/zero /one /two /three /four /five /six /seven 
/eight /nine /colon /semicolon /less /equal /greater /question 
/at /A /B /C /D /E /F /G 
/H /I /J /K /L /M /N /O 
/P /Q /R /S /T /U /V /W 
/X /Y /Z /bracketleft /backslash /bracketright /asciicircum /underscore 
/quoteleft /a /b /c /d /e /f /g 
/h /i /j /k /l /m /n /o 
/p /q /r /s /t /u /v /w 
/x /y /z /braceleft /bar /braceright /asciitilde /.notdef 
/.notdef /.notdef /.notdef /.notdef /.notdef /.notdef /.notdef /.notdef 
/.notdef /.notdef /.notdef /.notdef /.notdef /.notdef /.notdef /.notdef 
/.notdef /.notdef /.notdef /.notdef /.notdef /.notdef /.notdef /.notdef 
/.notdef /.notdef /.notdef /.notdef /.notdef /.notdef /.notdef /.notdef 
/space /exclamdown /cent /sterling /currency /yen /brokenbar /section 
/dieresis /copyright /ordfeminine /guillemotleft /logicalnot /hyphen /registered /macron 
/degree /plusminus /twosuperior /threesuperior /acute /mu /paragraph /bullet 
/cedilla /onesuperior /ordmasculine /guillemotright /onequarter /onehalf /threequarters /questiondown 
/Agrave /Aacute /Acircumflex /Atilde /Adieresis /Aring /AE /Ccedilla 
/Egrave /Eacute /Ecircumflex /Edieresis /Igrave /Iacute /Icircumflex /Idieresis 
/Eth /Ntilde /Ograve /Oacute /Ocircumflex /Otilde /Odieresis /multiply 
/Oslash /Ugrave /Uacute /Ucircumflex /Udieresis /Yacute /Thorn /germandbls 
/agrave /aacute /acircumflex /atilde /adieresis /aring /ae /ccedilla 
/egrave /eacute /ecircumflex /edieresis /igrave /iacute /icircumflex /idieresis 
/eth /ntilde /ograve /oacute /ocircumflex /otilde /odieresis /divide 
/oslash /ugrave /uacute /ucircumflex /udieresis /yacute /thorn /ydieresis 
] def
%%EndResource
% Initialize page description variables.
/sh 595 def
/sw 842 def
/llx 50 def
/urx 792 def
/ury 571 def
/lly 24 def
/#copies 1 def
%% Pagedevice definitions:
countdictstack
% Push our own mark, since there can be several PS marks pushed depending
% where the failure really occured.
/a2ps_mark
{
%%BeginFeature: *Tumble False
  (<<) cvx exec /Tumble (false) cvx exec (>>) cvx exec setpagedevice
%%EndFeature
%%BeginFeature: *Duplex True
  (<<) cvx exec /Duplex (true) cvx exec (>>) cvx exec setpagedevice
%%EndFeature
} stopped
% My cleartomark
{ /a2ps_mark eq { exit } if } loop
countdictstack exch sub dup 0 gt
{
  { end } repeat
}{
  pop
} ifelse
/th 15.000000 def
/fnfs 11 def
/bfs 7.473382 def
/cw 4.484029 def

% Dictionary for ISO-8859-1 support
/iso1dict 8 dict begin
  /fCourier ISO-8859-1Encoding /Courier reencode_font
  /fCourier-Bold ISO-8859-1Encoding /Courier-Bold reencode_font
  /fCourier-BoldOblique ISO-8859-1Encoding /Courier-BoldOblique reencode_font
  /fCourier-Oblique ISO-8859-1Encoding /Courier-Oblique reencode_font
  /fHelvetica ISO-8859-1Encoding /Helvetica reencode_font
  /fHelvetica-Bold ISO-8859-1Encoding /Helvetica-Bold reencode_font
  /fTimes-Bold ISO-8859-1Encoding /Times-Bold reencode_font
  /fTimes-Roman ISO-8859-1Encoding /Times-Roman reencode_font
currentdict end def
/bgcolor [ 0 0 0 ] def
/bg false def
/ul false def
/bx false def
% The font for line numbering
/f# /Helvetica findfont bfs .6 mul scalefont def
/fSymbol /Symbol findfont def
/hm fnfs 0.25 mul def
/pw
   cw 81.400000 mul
def
/ph
   505.947993 th add
def
/pmw urx llx sub pw 2 mul sub 1 div def
/pmh 0 def
/v 0 def
/x [
  0
  dup pmw add pw add
] def
/y [
  pmh ph add 0 mul ph add
  dup
] def
/scx sw 2 div def
/scy sh 2 div def
/snx urx def
/sny lly 2 add def
/dx llx def
/dy sny def
/fnx scx def
/fny dy def
/lx snx def
/ly ury fnfs 0.8 mul sub def
/sx 0 def
/tab 8 def
/x0 0 def
/y0 0 def
%%EndSetup

%%Page: (1) 1
%%BeginPageSetup
/pagesave save def
sh 0 translate 90 rotate
%%EndPageSetup
iso1dict begin
gsave
llx lly 12 add translate
/v 0 store
/x0 x v get 3.138821 add sx cw mul add store
/y0 y v get bfs th add sub store
x0 y0 moveto
(package) K
( linda;) p n
() N
(/** Callback when a tuple appears. */) C n
(public) K
( ) p
(interface) K
( ) p
(Callback) L
( {) p n
() N
() S 8 T () S
(/** Callback when a tuple appears. ) C n
() S 8 T ( * The callback is kept if it returns true, and is deregistered if it re) N
(turns false.) N
() S 8 T ( * See Linda.eventRegister for additional constraints.) N
() S 8 T ( * ) N
() S 8 T ( * @param t the new tuple) N
() S 8 T ( * @return true if the callback is kept, false if it is deregistered.) N
() S 8 T ( */) N
() p 8 T () S
(boolean) k
( call\(Tuple t\);) p n
(}) N
(Callback.java) (Page 1/1) (d\303\251c. 30, 12 17:54) title
border
grestore
(Printed by 'Glinel-mortreuil Quentin') rhead
(Callback.java) (1/5) (jeudi janvier 17, 2013) footer
end % of iso1dict
pagesave restore
showpage
%%Page: (1-2) 2
%%BeginPageSetup
/pagesave save def
sh 0 translate 90 rotate
%%EndPageSetup
iso1dict begin
gsave
llx lly 12 add translate
/v 0 store
/x0 x v get 3.138821 add sx cw mul add store
/y0 y v get bfs th add sub store
x0 y0 moveto
(package) K
( linda;) p n
() N
(import) K
( java.util.Collection;) p n
() N
(/** Public interface to a Linda implementation. */) C n
(public) K
( ) p
(interface) K
( ) p
(Linda) L
( {) p n
() S 8 T () N
() S 8 T () S
(/** Adds a tuple t to the tuplespace. */) C n
() p 8 T () S
(public) K
( ) p
(void) k
( write\(Tuple t\);) p n
() S 8 T () N
() S 8 T () S
(/** Returns a tuple matching the template and removes it from the tuples) C n
(pace.) N
() S 8 T ( * Blocks if no corresponding tuple is found. */) N
() p 8 T () S
(public) K
( Tuple take\(Tuple template\);) p n
() S 8 T () N
() S 8 T () S
(/** Returns a tuple matching the template and leaves it in the tuplespac) C n
(e.) N
() S 8 T ( * Blocks if no corresponding tuple is found. */) N
() p 8 T () S
(public) K
( Tuple read\(Tuple template\);) p n
() N
() S 8 T () S
(/** Returns a tuple matching the template and removes it from the tuples) C n
(pace.) N
() S 8 T ( * Returns null if none found. */) N
() p 8 T () S
(public) K
( Tuple tryTake\(Tuple template\);) p n
() N
() S 8 T () S
(/** Returns a tuple matching the template and leaves it in the tuplespac) C n
(e.) N
() S 8 T ( * Returns null if none found. */) N
() p 8 T () S
(public) K
( Tuple tryRead\(Tuple template\);) p n
() N
() S 8 T () S
(/** Returns all the tuples matching the template and removes them from t) C n
(he tuplespace.) N
() S 8 T ( * Returns an empty collection if none found \(never blocks\).) N
() S 8 T ( * Note: there is no atomicity or consistency constraints between takeAl) N
(l and other methods;) N
() S 8 T ( * for instance two concurrent takeAll with similar templates may split ) N
(the tuples between the two results. ) N
() S 8 T ( */) N
() p 8 T () S
(public) K
( Collection<Tuple> takeAll\(Tuple template\);) p n
() S 8 T () N
() S 8 T () S
(/** Returns all the tuples matching the template and leaves them in the ) C n
(tuplespace.) N
() S 8 T ( * Returns an empty collection if none found \(never blocks\).) N
() S 8 T ( * Note: there is no atomicity or consistency constraints between readAl) N
(l and other methods;) N
() S 8 T ( * for instance \(write\([1]\);write\([2]\)\) || readAll\([?Integer]\) may retur) N
(n only [2].) N
() S 8 T ( */) N
() p 8 T () S
(public) K
( Collection<Tuple> readAll\(Tuple template\);) p n
() S 8 T () N
() S 8 T () S
(/** Registers a callback which will be called when a tuple matching the ) C n
(template appears.) N
() S 8 T ( * The found tuple is removed from the tuplespace.) N
() S 8 T ( * The callback is kept if it returns true, and is deregistered if it re) N
(turns false. This is the only way to deregister a callback.) N
() S 8 T ( * Note that the callback may immediately fire if a matching tuple is al) N
(ready present. And as long as it returns true, it immediately fires multiple tim) N
(es.) N
() S 8 T ( * Beware: as the firing must wait for the return value of the callback,) N
( the callback must never block \(see {@link AsynchronousCallback} class\). ) N
() S 8 T ( * Callbacks are not ordered: if more than one may be fired, the chosen ) N
(one is arbitrary.) N
() S 8 T ( * ) N
() S 8 T ( * @param template the filtering template.) N
() S 8 T ( * @param callback the callback to call if a matching tuple appears.) N
() S 8 T ( */) N
() p 8 T () S
(public) K
( ) p
(void) k
( eventRegister\(Tuple template, Callback callback\);) p 72 T () N
(Linda.java) (Page 1/2) (d\303\251c. 30, 12 17:54) title
border
/v 1 store
/x0 x v get 3.138821 add sx cw mul add store
/y0 y v get bfs th add sub store
x0 y0 moveto
() p 8 T () N
() S 8 T () S
(/** To debug, prints any information it wants \(e.g. the tuples in tuples) C n
(pace or the registered callbacks\), prefixed by <code>prefix</code. */) N
() p 8 T () S
(public) K
( ) p
(void) k
( debug\(String prefix\);) p n
() N
(}) N
(Linda.java) (Page 2/2) (d\303\251c. 30, 12 17:54) title
border
grestore
(Printed by 'Glinel-mortreuil Quentin') rhead
(Linda.java) (2/5) (jeudi janvier 17, 2013) footer
end % of iso1dict
pagesave restore
showpage
%%Page: (1) 3
%%BeginPageSetup
/pagesave save def
sh 0 translate 90 rotate
%%EndPageSetup
iso1dict begin
gsave
llx lly 12 add translate
/v 0 store
/x0 x v get 3.138821 add sx cw mul add store
/y0 y v get bfs th add sub store
x0 y0 moveto
(package) K
( linda;) p n
() N
(@SuppressWarnings\(") S
(serial) str
("\)) p n
(public) K
( ) p
(class) K
( ) p
(TupleFormatException) L
( ) p
(extends) K
( IllegalArgumentException {) p n
() S 8 T () N
() S 8 T () S
(public) K
( TupleFormatException\(String s\) {) p n
() S 8 T () S 16 T () S
(super) K
(\(s\);) p n
() S 8 T (}) N
() N
(}) N
(TupleFormatException.java) (Page 1/1) (d\303\251c. 30, 12 17:54) title
border
grestore
(Printed by 'Glinel-mortreuil Quentin') rhead
(TupleFormatException.java) (3/5) (jeudi janvier 17, 2013) footer
end % of iso1dict
pagesave restore
showpage
%%Page: (1-2) 4
%%BeginPageSetup
/pagesave save def
sh 0 translate 90 rotate
%%EndPageSetup
iso1dict begin
gsave
llx lly 12 add translate
/v 0 store
/x0 x v get 3.138821 add sx cw mul add store
/y0 y v get bfs th add sub store
x0 y0 moveto
(package) K
( linda;) p n
(import) K
( java.io.ByteArrayInputStream;) p n
(import) K
( java.io.ByteArrayOutputStream;) p n
(import) K
( java.io.ObjectInputStream;) p n
(import) K
( java.io.ObjectOutputStream;) p n
(import) K
( java.io.Serializable;) p n
(import) K
( java.util.Iterator;) p n
(import) K
( java.util.LinkedList;) p n
(import) K
( java.util.StringTokenizer;) p n
() N
(public) K
( ) p
(class) K
( ) p
(Tuple) L
( ) p
(extends) K
( LinkedList<Serializable> ) p
(implements) K
( Serializable {) p n
() S 8 T () N
() S 8 T () S
(private) K
( ) p
(static) K
( ) p
(final) K
( ) p
(long) k
( serialVersionUID = 1L;) p n
() N
() S 8 T () S
(/** Creates a new tuple.) C n
() S 8 T ( * Example :) N
() S 8 T ( * new Tuple\(4, 5, "foo", true\)  -> [ 4 5 "foo" true ]) N
() S 8 T ( * new Tuple\(4, Integer.class, "foo".getclass\(\), Boolean.class\)  -> [ 4 ) N
(?Integer ?String ?Boolean ]) N
() S 8 T ( */) N
() p 8 T () S
(public) K
( Tuple\(Serializable... components\) {) p n
() S 8 T () S 16 T () S
(for) K
( \(Serializable c : components\) {) p n
() S 8 T () S 16 T () S 24 T (this.add\(c\);) N
() S 8 T () S 16 T (}) N
() S 8 T (}) N
() N
() S 8 T () S
(private) K
( ) p
(static) K
( ) p
(boolean) k
( matches\(Serializable thiscomponent, Serializable ) p n
(templatecomponent\) {) N
() S 8 T () S 16 T () S
(if) K
( \(templatecomponent ) p
(instanceof) K
( Tuple\) {) p n
() S 8 T () S 16 T () S 24 T () S
(if) K
( \(! \(thiscomponent ) p
(instanceof) K
( Tuple\)\)) p n
() S 8 T () S 16 T () S 24 T () S 32 T () S
(return) K
( ) p
(false) k
(;) p n
() S 8 T () S 16 T () S 24 T () S
(else) K n
() p 8 T () S 16 T () S 24 T () S 32 T () S
(return) K
( \(\(Tuple\)thiscomponent\).matches\(\(Tuple\)tem) p n
(platecomponent\);) N
() S 8 T () S 16 T (} ) S
(else) K
( ) p
(if) K
( \(templatecomponent ) p
(instanceof) K
( Class\) {) p n
() S 8 T () S 16 T () S 24 T () S
(if) K
( \(thiscomponent ) p
(instanceof) K
( Class\)) p n
() S 8 T () S 16 T () S 24 T () S 32 T () S
(return) K
( thiscomponent.equals\(templatecomponent\);) p n
() S 8 T () S 16 T () S 24 T () S
(else) K n
() p 8 T () S 16 T () S 24 T () S 32 T () S
(return) K
( \(\(Class<?>\) templatecomponent\).isInstance) p n
(\(thiscomponent\);) N
() S 8 T () S 16 T (} ) S
(else) K
( {) p n
() S 8 T () S 16 T () S 24 T () S
(return) K
( thiscomponent.equals\(templatecomponent\);) p n
() S 8 T () S 16 T (}) N
() N
() S 8 T (}) N
() S 8 T () N
() S 8 T () S
(/** Returns true if this tuple matches the given template.) C n
() S 8 T ( * Matching rules : a tuple matches a template if all their components m) N
(atch two by two.) N
() S 8 T ( * Two components match :) N
() S 8 T ( *  - if they are both values and are equals; ) N
() S 8 T ( *  - if the template component is a class, and the tuple component is a) N
(n instance of this class;) N
() S 8 T ( *  - recursively if both are tuples.) N
() S 8 T ( *  ) N
() S 8 T ( *  Examples:) N
() S 8 T ( *   [ 3 5 "foo" ] matches [ 3 5 "foo" ], [ ?Integer 5 "foo" ], [ ?Integ) N
(er ?Integer ?String ]) N
() S 8 T ( *   [ 3 ?Integer [ 6 7 ] [ 7 8 ] ] matches [ ?Integer ?Integer [ ?Integ) N
(er 7 ] ?Tuple ], [3 ?Integer ?Tuple ?Tuple ]) N
() S 8 T ( *   ) N
() S 8 T ( *   @param template the template which this tuple is compared to.) N
() S 8 T ( */) S
( ) p n
() S 8 T () S
(public) K
( ) p
(boolean) k
( matches\(Tuple template\) {) p n
() S 8 T () S 16 T () S
(if) K
( \(this.size\(\) != template.size\(\)\)) p n
() S 8 T () S 16 T () S 24 T () S
(return) K
( ) p
(false) k
(;) p n
() S 8 T () S 16 T (Iterator<Serializable> itthis = this.iterator\(\);) N
(Tuple.java) (Page 1/4) (d\303\251c. 30, 12 17:54) title
border
/v 1 store
/x0 x v get 3.138821 add sx cw mul add store
/y0 y v get bfs th add sub store
x0 y0 moveto
() p 8 T () S 16 T (Iterator<Serializable> itmotif = template.iterator\(\);) N
() S 8 T () S 16 T () S
(while) K
( \(itthis.hasNext\(\)\) {) p n
() S 8 T () S 16 T () S 24 T (Serializable othis = itthis.next\(\);) N
() S 8 T () S 16 T () S 24 T (Serializable omotif = itmotif.next\(\);) N
() S 8 T () S 16 T () S 24 T () S
(if) K
( \(! matches\(othis, omotif\)\)) p n
() S 8 T () S 16 T () S 24 T () S 32 T () S
(return) K
( ) p
(false) k
(;) p n
() S 8 T () S 16 T (}) N
() S 8 T () S 16 T () S
(return) K
( ) p
(true) k
(;) p n
() S 8 T (}) N
() S 8 T () N
() S 8 T () S
(/** Returns true if this tuple \(seen as a template\) contains <code>t</co) C n
(de>.) N
() S 8 T ( * This is the reverse of {@link #matches\(Tuple\)}. */) N
() p 8 T () S
(public) K
( ) p
(boolean) k
( contains\(Tuple t\) {) p n
() S 8 T () S 16 T () S
(return) K
( t.matches\() p
(this) k
(\);) p n
() S 8 T (}) N
() S 8 T () N
(    ) S
(/**) C n
(     * Returns a deep copy of the tuple.) N
(     * @return a deep copy of this object) N
(     */) N
(   ) p
(/* Les \303\251l\303\251ments types sont repr\303\251sent\303\251s par des instances de Class, qui n') c n
(est pas cloneable.) N
(    * Le plus simple de passer par une s\303\251rialisation/des\303\251rialisation ce qui ma) N
(rche pour toutes les classes qui implantent serializable.) N
(    */) N
(   ) p
(public) K
( Tuple deepclone\(\) {) p n
(       Tuple copy = ) S
(null) k
(;) p n
(       ) S
(try) K
( {) p n
(           ByteArrayOutputStream buf = ) S
(new) K
( ByteArrayOutputStream\(\);) p n
(           ObjectOutputStream out = ) S
(new) K
( ObjectOutputStream \(buf\);) p n
(           out.writeObject \() S
(this) k
(\);) p n
(           ObjectInputStream in = ) S
(new) K
( ObjectInputStream \() p
(new) K
( ByteArrayInputStrea) p n
(m \(buf.toByteArray\(\)\)\);) N
(           copy = \(Tuple\) in.readObject\(\);) N
(       } ) S
(catch) K
( \(Exception e\) {) p n
(           e.printStackTrace\(\);) N
(       }) N
(       ) S
(return) K
( copy;) p n
(   }) N
(   ) N
(   ) S
(/** Returns a string representation of this tuple.) C n
(    * @return a string representation of this tuple.) N
(    */) N
() p 8 T () S
(public) K
( String toString\(\) {) p n
() S 8 T () S 16 T (StringBuilder sb = ) S
(new) K
( StringBuilder\(\);) p n
() S 8 T () S 16 T (sb.append\(") S
([) str
("\);) p n
() S 8 T () S 16 T () S
(for) K
( \(Object o : ) p
(this) k
(\) {) p n
() S 8 T () S 16 T () S 24 T () S
(if) K
( \(o ) p
(instanceof) K
( Class\) {) p n
() S 8 T () S 16 T () S 24 T () S 32 T (sb.append\(") S
( ?) str
(" + \(\(Class<?>\)o\).getName\(\)\);) p n
() S 8 T () S 16 T () S 24 T (} ) S
(else) K
( ) p
(if) K
( \(o ) p
(instanceof) K
( String\) {) p n
() S 8 T () S 16 T () S 24 T () S 32 T (sb.append\(") S
( \\") str
(" + o + ") p
(\\") str
("\);) p n
() S 8 T () S 16 T () S 24 T (} ) S
(else) K
( ) p
(if) K
( \(o ) p
(instanceof) K
( Character\) {) p n
() S 8 T () S 16 T () S 24 T () S 32 T (sb.append\(") S
( ') str
(" + o + ") p
(') str
("\);) p n
() S 8 T () S 16 T () S 24 T (} ) S
(else) K
( {) p n
() S 8 T () S 16 T () S 24 T () S 32 T (sb.append\(") S
( ) str
(" + o.toString\(\)\);) p n
() S 8 T () S 16 T () S 24 T (}) N
() S 8 T () S 16 T (}) N
() S 8 T () S 16 T (sb.append\(") S
( ]) str
("\);) p n
() S 8 T () S 16 T () S
(return) K
( sb.toString\(\);) p n
() S 8 T (}) N
() S 8 T () N
() S 8 T () S
(/** Parses a sequence of words to form a tuple.) C n
() S 8 T ( * The initial [ must be missing.) N
() S 8 T ( * @param stk) N
() S 8 T ( * @return) N
() S 8 T ( * @throws TupleFormatException) N
(Tuple.java) (Page 2/4) (d\303\251c. 30, 12 17:54) title
border
grestore
(Printed by 'Glinel-mortreuil Quentin') rhead
(Tuple.java) (4/5) (jeudi janvier 17, 2013) footer
end % of iso1dict
pagesave restore
showpage
%%Page: (3-4) 5
%%BeginPageSetup
/pagesave save def
sh 0 translate 90 rotate
%%EndPageSetup
iso1dict begin
gsave
llx lly 12 add translate
/v 0 store
/x0 x v get 3.138821 add sx cw mul add store
/y0 y v get bfs th add sub store
x0 y0 moveto
() C 8 T ( */) N
() p 8 T () S
(private) K
( ) p
(static) K
( Tuple valueOf\(StringTokenizer stk\) ) p
(throws) K
( TupleFormatExce) p n
(ption {) N
() S 8 T () S 16 T (Tuple res = ) S
(new) K
( Tuple\(\);) p n
() S 8 T () S 16 T () S
(while) K
( \(stk.hasMoreTokens\(\)\) {) p n
() S 8 T () S 16 T () S 24 T (String token = stk.nextToken\(\);) N
() S 8 T () S 16 T () S 24 T () S
(if) K
( \(token.equals\(") p
(]) str
("\)\)) p n
() S 8 T () S 16 T () S 24 T () S 32 T () S
(return) K
( res; ) p
(// BEWARE) c n
() p 8 T () S 16 T () S 24 T () S
(if) K
( \(token.startsWith\(") p
(\\") str
("\) && token.endsWith\(") p
(\\") str
("\)\) {) p n
() S 8 T () S 16 T () S 24 T () S 32 T (String val = token.substring\(1, token.length\(\)-1) N
(\);) N
() S 8 T () S 16 T () S 24 T () S 32 T (res.add\(val\);) N
() S 8 T () S 16 T () S 24 T (} ) S
(else) K
( ) p
(if) K
( \(token.startsWith\(") p
(') str
("\) && token.endsWith\(") p
(') str
("\) ) p n
(&& \(token.length\(\) > 2\)\) {) N
() S 8 T () S 16 T () S 24 T () S 32 T () S 40 T (res.add\() S
(new) K
( Character\(token.charAt\(1\)\)\);) p n
() S 8 T () S 16 T () S 24 T (} ) S
(else) K
( ) p
(if) K
( \(token.startsWith\(") p
(?) str
("\)\) {) p n
() S 8 T () S 16 T () S 24 T () S 32 T (String classname = token.substring\(1\);) N
() S 8 T () S 16 T () S 24 T () S 32 T (Class<?> c = ) S
(null) k
(;) p n
() S 8 T () S 16 T () S 24 T () S 32 T () S
(final) K
( String[] prefixes = { "", ") p
(java.lang.) str
(", ") p
(linda.) str
() p n
(" };) N
() S 8 T () S 16 T () S 24 T () S 32 T () S
(for) K
( \(String prefix : prefixes\) {) p n
() S 8 T () S 16 T () S 24 T () S 32 T () S 40 T () S
(try) K
( {) p n
() S 8 T () S 16 T () S 24 T () S 32 T () S 40 T () S 48 T (c = Class.forName\(prefix + class) N
(name\);) N
() S 8 T () S 16 T () S 24 T () S 32 T () S 40 T () S 48 T () S
(break) K
(; ) p
(// oh !) c n
() p 8 T () S 16 T () S 24 T () S 32 T () S 40 T (} ) S
(catch) K
( \(ClassNotFoundException e\) {) p n
() S 8 T () S 16 T () S 24 T () S 32 T () S 40 T () S 48 T () S
(// ignore and try next prefix) c n
() p 8 T () S 16 T () S 24 T () S 32 T () S 40 T (}) N
() S 8 T () S 16 T () S 24 T () S 32 T (}) N
() S 8 T () S 16 T () S 24 T () S 32 T () S
(if) K
( \(c != ) p
(null) k
(\)) p n
() S 8 T () S 16 T () S 24 T () S 32 T () S 40 T (res.add\(c\);) N
() S 8 T () S 16 T () S 24 T () S 32 T () S
(else) K n
() p 8 T () S 16 T () S 24 T () S 32 T () S 40 T () S
(throw) K
( ) p
(new) K
( TupleFormatException\(") p
(Unknown c) str n
(lass ?) S
("+classname\);) p n
() S 8 T () S 16 T () S 24 T (} ) S
(else) K
( ) p
(if) K
( \(") p
(-0123456789) str
(".indexOf\(token.charAt\(0\)\) != -1\) ) p n
({) N
() S 8 T () S 16 T () S 24 T () S 32 T () S
(int) k
( val;) p n
() S 8 T () S 16 T () S 24 T () S 32 T () S
(try) K
( {) p n
() S 8 T () S 16 T () S 24 T () S 32 T () S 40 T (val = Integer.valueOf\(token\);) N
() S 8 T () S 16 T () S 24 T () S 32 T (} ) S
(catch) K
( \(NumberFormatException e\) {) p n
() S 8 T () S 16 T () S 24 T () S 32 T () S 40 T () S
(throw) K
( ) p
(new) K
( TupleFormatException\(") p
(NumberFor) str n
(matException on ') S
("+token+") p
(') str
("\);) p 32 T () S 40 T () S 48 T () S 56 T () S 64 T () N
() S 8 T () S 16 T () S 24 T () S 32 T (}) N
() S 8 T () S 16 T () S 24 T () S 32 T (res.add\(val\);) N
() S 8 T () S 16 T () S 24 T (} ) S
(else) K
( ) p
(if) K
( \(token.equals\(") p
(true) str
("\)\) {) p n
() S 8 T () S 16 T () S 24 T () S 32 T (res.add\() S
(true) k
(\);) p n
() S 8 T () S 16 T () S 24 T (} ) S
(else) K
( ) p
(if) K
( \(token.equals\(") p
(false) str
("\)\) {) p n
() S 8 T () S 16 T () S 24 T () S 32 T (res.add\() S
(false) k
(\);) p n
() S 8 T () S 16 T () S 24 T (} ) S
(else) K
( ) p
(if) K
( \(token.equals\(") p
([) str
("\)\) {) p n
() S 8 T () S 16 T () S 24 T () S 32 T (Tuple val = valueOf\(stk\); ) S
(// yeepi!) c n
() p 8 T () S 16 T () S 24 T () S 32 T (res.add\(val\);) N
() S 8 T () S 16 T () S 24 T (} ) S
(else) K
( {) p n
() S 8 T () S 16 T () S 24 T () S 32 T () S
(throw) K
( ) p
(new) K
( TupleFormatException\(") p
(Unhandled chars: ') str
("+t) p n
(oken+") S
(') str
("\);) p n
() S 8 T () S 16 T () S 24 T (}) N
() S 8 T () S 16 T (}) N
() S 8 T () S 16 T () S
(throw) K
( ) p
(new) K
( TupleFormatException\(") p
(Missing closing ']') str
("\);) p n
() S 8 T (}) N
() N
() S 8 T () S
(/** Returns a Tuple with a value represented by the specified String.) C n
() S 8 T ( * Known values: integer \(45, -67\), boolean \(true, false\), string \("toto) N
("\), classname \(?Integer\), recursive tuple.) N
() S 8 T ( * Examples: [ 3 4 ], [ ?Integer "toto" true 78 ?Boolean ], [ ?Integer ?) N
(Tuple ], [ [ true 78 ]  [ 3 4 [ 5 6 ] 7 ] ]) N
() S 8 T ( * For these components, the parsable strings are identical to the print) N
(ed strings.) N
() S 8 T ( * Note: do not expect the parser to be resilient to arbitrary strings.) N
(Tuple.java) (Page 3/4) (d\303\251c. 30, 12 17:54) title
border
/v 1 store
/x0 x v get 3.138821 add sx cw mul add store
/y0 y v get bfs th add sub store
x0 y0 moveto
() C 8 T ( * ) N
() S 8 T ( * @param s the string to be parsed.) N
() S 8 T ( * @return a Tuple object holding the value represented by the string ar) N
(gument.) N
() S 8 T ( * @throws TupleFormatException) N
() S 8 T ( */) N
() p 8 T () S
(public) K
( ) p
(static) K
( Tuple valueOf\(String s\) ) p
(throws) K
( TupleFormatException {) p n
() S 8 T () S 16 T (StringTokenizer stk = ) S
(new) K
( StringTokenizer\(s\);) p n
() S 8 T () S 16 T () S
(if) K
( \(! stk.hasMoreTokens\(\) || !stk.nextToken\(\).equals\(") p
([) str
("\)\)) p n
() S 8 T () S 16 T () S 24 T () S
(throw) K
( ) p
(new) K
( TupleFormatException\(") p
(Missing initial '[') str
("\);) p n
() S 8 T () S 16 T (Tuple res = valueOf\(stk\);) N
() S 8 T () S 16 T () S
(if) K
( \(stk.hasMoreTokens\(\)\)) p n
() S 8 T () S 16 T () S 24 T () S
(throw) K
( ) p
(new) K
( TupleFormatException\(") p
(Trailing chars after ']') str
("\);) p n
() S 8 T () S 16 T () S
(return) K
( res;) p n
() S 8 T (}) N
() S 8 T () N
(}) N
(Tuple.java) (Page 4/4) (d\303\251c. 30, 12 17:54) title
border
grestore
(Printed by 'Glinel-mortreuil Quentin') rhead
(Tuple.java) (5/5) (jeudi janvier 17, 2013) footer
end % of iso1dict
pagesave restore
showpage

%%Trailer
end
%%EOF
