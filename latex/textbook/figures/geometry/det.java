                  /*  File:  det.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class det extends Template {

     static {templateClass = new det() ; }

     public void setup() {
          filePrefix = "det" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.1*1.2 ;      // in inches
          ysize = 0.9 ;   // in inches. 
          xmin =  0 ;
          xmax = 535*1.2 ;
          ymin = -50 ;
          ymax =  40 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
         fEnv("lineWidth", 1.0) ;
         fTeXlabel( -15, 0, "lc", "$\\det \\left[\\begin{matrix}i& j & k\\\\ a_1&a_2&a_3\\\\ b_1&b_2&b_3\\end{matrix}\\right]$") ;
         fTeXlabel( 110, 0, "lc", "$\\ =\\ i\\det \\left[\\begin{matrix}i\\kern7pt& j & k\\\\ a_1&a_2&a_3\\\\ b_1&b_2&b_3\\end{matrix}\\right]$") ;
         fTeXlabel( 268, 0, "lc", "$\\ -\\ j\\det \\left[\\begin{matrix}i& j\\kern5pt & k\\\\ a_1&a_2&a_3\\\\ b_1&b_2&b_3\\end{matrix}\\right]$") ;
         fTeXlabel( 433, 0, "lc", "$\\ +\\ k\\det \\left[\\begin{matrix}i& j & k\\kern3pt\\\\ a_1&a_2&a_3\\\\ b_1&b_2&b_3\\end{matrix}\\right]$") ;

         fTeXlabel( 110, -48, "lc", "$\\ =\\ i\\,(a_2b_3-a_3b_2)$") ;
         fTeXlabel( 250, -48, "lc", "$\\,-\\,j\\,(a_1b_3-a_3b_1)$") ;
         fTeXlabel( 398, -48, "lc", "$\\,+\\,k\\,(a_1b_2-a_2b_1)$") ;

         fLine( 184, 20,  263, 20) ;
         fLine( 190, 27,  190, -30) ;

         fLine( 342, 20,  420, 20) ;
         fLine( 377, 27,  377, -30) ;

         fLine( 508, 20,  586, 20) ;
         fLine( 573, 27,  573, -30) ;

     }
}
