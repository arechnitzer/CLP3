                  /*  File:  OE11D_8d.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE11D_8d extends Template {

     static {templateClass = new OE11D_8d() ; }

     public void setup() {
          filePrefix = "OE11D_8d" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.0*0.5 ;      // in inches
          ysize = 4.0*0.5 ;   // in inches. 
          xmin = -2.0 ;
          xmax = 2.0 ;
          ymin = 2.5 ;
          ymax =  6.5 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("psFillGray", 0.9) ;
          double sq3 = Math.sqrt(3) ;
          double sq12 = Math.sqrt(12) ;
//          fDisk(0,0, sq12,sq12, FILLED) ;
          fDisk(0,4, 2,2, FILLED) ;
          fEnv("psFillGray", 1.0) ;
          double x1 = 0 ; double y1 = 4 ;
          double x2 = sq3 ; double y2 = 3 ;
          double x3 = 0 ; double y3 = 0 ;
          double x4 = -sq3 ; double y4 = 3 ;
          { 
            double[] xlist = { x1, x2, x3, x4} ;
            double[] ylist = { y1, y2, y3, y4} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
//          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
//          fTeXlabel(-0.1, ymax, "tr", "$z$") ;
//          fDisk(0,0, sq12,sq12, CLOSED) ;
//          fDisk(0,4, 2,2, CLOSED) ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
              fLine(-sq3,3,  0,3) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;

//          fTeXlabel(3.2, 3, "lc", "$z=3$") ;
//          fTeXlabel(-2.0, 5, "rc", "$x^2+y^2+(z-4)^2=4$") ;
//          fTeXlabel(-3.2, -2, "rc", "$x^2+y^2+z^2=12$") ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
//          fEllipticalArc(0,0, sq12, sq12, 120,420, OPEN) ;
          fEllipticalArc(0,4, 2,2,-30, 210, OPEN) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(x1,y1, x2,y2) ;
          fLine(x1,y1, x4,y4) ;
//          { 
//            double[] xlist = { x1, x2, x3, x4} ;
//            double[] ylist = { y1, y2, y3, y4} ;
//            fPolygon(xlist, ylist, 4, CLOSED) ;
//           }   

          fEnv("psFillGray", 0.0) ;
         double r = 0.07 ;
//         fDisk(0,0, r,r, FILLED) ;   
//          fTeXlabel(0.15, 0.05, "lb", "$\\scriptstyle (0,0,0)$") ;
          fTeXlabel(0.05, 4.05, "lb", "$\\scriptstyle (0,0,4)$") ;
          fTeXlabel(1.87, 3.05, "lb", "$\\scriptstyle (\\sqrt{3},0,3)$") ;
         fEnv("lineWidth",0.5) ;
         double R = 0.3 ;
         fEllipticalArc(0,4, R,R,90, 210, OPEN) ;
         fTeXlabel(-0.33, 4.05, "br", "$\\scriptstyle 2\\pi/3$") ;
         fEllipticalArc(0,0, R,R,120, 180, OPEN) ;
//         fTeXlabel(-0.32, 0.1, "br", "$\\scriptstyle \\pi/3$") ;


         fTeXlabel(-sq3/2, 2.95, "tc", "$\\scriptstyle \\sqrt{3}$") ;
         fTeXlabel(-sq3/2, 3.55, "br", "$\\scriptstyle 2$") ;
//         fTeXlabel(-sq3/2-0.1, 1.5, "tr", "$\\scriptstyle 2\\sqrt{3}$") ;


       
         fDisk(0,4, r,r, FILLED) ; 
         fDisk(sq3,3, r,r, FILLED) ;          
         
          
     }
}
