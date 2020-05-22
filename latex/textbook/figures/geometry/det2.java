                  /*  File:  det2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class det2 extends Template {

     static {templateClass = new det2() ; }

     public void setup() {
          filePrefix = "det2" ;   
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
         fTeXlabel( -15, 0, "lc", "$\\det \\left[\\begin{matrix}a_1&a_2&a_3\\\\ b_1&b_2&b_3\\\\ c_1&c_2&c_3\\end{matrix}\\right]$") ;
         fTeXlabel( 110, 0, "lc", "$=a_1\\det \\left[\\begin{matrix}a_1&a_2&a_3\\\\ b_1&b_2&b_3\\\\ c_1&c_2&c_3\\end{matrix}\\right]$") ;
         fTeXlabel( 268, 0, "lc", "$\\ -\\ a_2\\det \\left[\\begin{matrix}a_1&a_2&a_3\\\\ b_1&b_2&b_3\\\\ c_1&c_2&c_3\\end{matrix}\\right]$") ;
         fTeXlabel( 433, 0, "lc", "$\\ +\\ a_3\\det \\left[\\begin{matrix}a_1&a_2&a_3\\\\ b_1&b_2&b_3\\\\ c_1&c_2&c_3\\end{matrix}\\right]$") ;

         fTeXlabel( 110, -48, "lc", "$=a_1\\,(b_2c_3-b_3c_2)$") ;
         fTeXlabel( 250, -48, "lc", "$\\,-\\,a_2\\,(b_1c_3-b_3c_1)$") ;
         fTeXlabel( 398, -48, "lc", "$\\,+\\,a_3\\,(b_1c_2-b_2c_1)$") ;

         fLine( 183, 20,  263, 20) ;
         fLine( 190, 25,  190, -30) ;

         fLine( 347, 20,  428, 20) ;
         fLine( 386, 25,  386, -30) ;

         fLine( 513, 20,  592, 20) ;
         fLine( 580, 25,  580, -30) ;

     }
}
