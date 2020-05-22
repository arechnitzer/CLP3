                  /*  File:  planeLevel.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class planeLevel extends Template {

     static {templateClass = new planeLevel() ; }

     public void setup() {
          filePrefix = "planeLevel" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*1.2 ;      // in inches
          ysize = 2*1.2 ;   // in inches. 
          xmin = -2.2 ;
          xmax = 2.2 ;
          ymin = -2.2 ;
          ymax = 2.2 ;
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
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, ymax) ;
         fTeXlabel(xmax+0.1, 0, "cl", "$x$") ;
         fTeXlabel(0, ymax+0.1, "cb", "$y$") ;
         fLine(1,0, 1,-0.1) ;
         fTeXlabel(1, -0.15, "tc", "$1$") ;
         fLine(0, 1, -0.1,1) ;
         fTeXlabel(-0.15, 1, "rc", "$1$") ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("lineWidth", 1.0) ;
         double C = 0 ; 
              fLine(-C-ymin,ymin,  -C-ymax,ymax) ;
              fTeXlabel(-C-ymin+0.05,ymin, "bl", "${\\scriptstyle f=0}$") ;
         C = 1 ;  
              fLine(-C-ymin,ymin,  -C-ymax,ymax) ;
              fTeXlabel(-C-ymin+0.05,ymin, "bl", "${\\scriptstyle f=1}$") ;
         C = -1 ;  
              fLine(-C-ymin,ymin,  -C-ymax,ymax) ;
              fTeXlabel(xmax+0.05, -C-xmax, "bl", "${\\scriptstyle f=-1}$") ;
         C = 2 ;  
              fLine(-C-ymin,ymin,  -C-ymax,ymax) ;
              fTeXlabel(-C-ymin+0.05,ymin, "bl", "${\\scriptstyle f=2}$") ;
         C = -2 ;  
              fLine(-C-ymin,ymin,  -C-ymax,ymax) ;
              fTeXlabel(xmax+0.05, -C-xmax, "tl", "${\\scriptstyle f=-2}$") ;
         C = 3 ;  
              fLine(-C-ymin,ymin,  -C-ymax,ymax) ;
              fTeXlabel(-C-ymin+0.05,ymin, "bl", "${\\scriptstyle f=3}$") ;
         C = -3 ;  
              fLine(-C-ymin,ymin,  -C-ymax,ymax) ;
              fTeXlabel(xmax+0.05, -C-xmax, "bl", "${\\scriptstyle f=-3}$") ;


          
     }
}
