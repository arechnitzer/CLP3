                  /*  File:  fBLevel.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class fBLevel extends Template {

     static {templateClass = new fBLevel() ; }

     public void setup() {
          filePrefix = "fBLevel" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6*0.5 ;      // in inches
          ysize = 22*0.14 ;   // in inches. 
          xmin = -1 ;
          xmax = 5 ;
          ymin = -2 ;
          ymax = 20 ;
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
         double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
         double r = 0.05 ;
         fEnv("lineWidth", 0.5) ;
//         fLine(xmin, 0, xmax, 0) ;
//         fLine(0, ymin, 0, ymax) ;
         fTeXlabel(xmax, -0.2, "tr", "$x$") ;
         fTeXlabel(-0.05, ymax, "tr", "$y$") ;

          fEnv("psFillGray", 0.9) ;
          {double[] xlist = {0, 3, 0} ;
           double[] ylist = {0, 0, 15} ;
           fPolygon(xlist, ylist, 3, FILLED) ;
          }

          {double[] xlist = {3, xmax, xmax, xmax} ;
           double[] ylist = {0, 0,    ymin, 15-5*xmax} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
          }

          {double[] xlist = {0, 0,    xmin, xmin} ;
           double[] ylist = {0, ymin, ymin, 0} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
          }

          {double[] xlist = {xmin, 0, 0} ;
           double[] ylist = {15-5*xmin, ymax, 15} ;
           fPolygon(xlist, ylist, 3, FILLED) ;
          }


         String Red = "0 1 1 0 setcmykcolor  " ;
         String Blue = "1 1 0 0 setcmykcolor  " ;
         String Black = "0 0 0 1 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("useColorPs", "true") ;

           fEnv("lineWidth", 0.5) ;
           canvas.append( new fPsWrite(Black+"\n")) ;
           fEnv("psFillColor", Black) ;
                  fArrow(4,4, 3.05,0.05) ;
                  fTeXlabel(4.5,4.2, "cb", "${\\scriptstyle (3,0),\\ f(3,0)=0}$") ;
                  fArrow(-1,3, -0.05,0.05) ;
                  fTeXlabel(-1.05,3, "br", "${\\scriptstyle f(0,0)=0,\\ (0,0)}$") ;
                  fArrow(1,15, 0.05,15) ;
                  fTeXlabel(1,15, "cl", "${\\scriptstyle (0,15),\\ f(0,15)=0}$") ;
                  fArrow(-1,10, 0.93,5.1) ;
                  fTeXlabel(-1.05,10, "br", "${\\scriptstyle f(1,5)=-25,\\ (1,5)}$") ;
           canvas.append( new fPsWrite(Red+"\n")) ;
           fEnv("lineWidth", 1.0) ;



//             fTeXlabel(-0.35,0.2, "br", "${\\scriptstyle f=0}$") ;

           double C ;
           C = 0; 
           fLine(xmin, 0, xmax, 0) ;
           fLine(0, ymin, 0, ymax) ;
           fLine(xmin, 15-5*xmin, xmax, 15-5*xmax) ;
                  fTeXlabel(2.3,0.1, "cb", "${\\scriptstyle f=0}$") ;

           C = -10;  fCurve(new YP(C), 0.21, 2.1, OPEN) ;
                    fCurve(new YM(C), 0.21, 2.1, OPEN) ;
                    fCurve(new YP(C), 3.67, 4.7, OPEN) ;
//                    fCurve(new YM(C), 3.67, 4.7, OPEN) ;
//                    fCurve(new YP(C), -1, -0.3, OPEN) ;
                    fCurve(new YM(C), -1, -0.16, OPEN) ;

                    fCurve(new XP(C), 1.5, 10, OPEN) ;
                    fCurve(new XM(C), 1.5, 10, OPEN) ;
                    fCurve(new XP(C), -2, -0.3, OPEN) ;
                    fCurve(new XM(C), -2, -0.3, OPEN) ;
//           fEnv("lineWidth", 0.5) ;
//           canvas.append( new fPsWrite(Black+"\n")) ;
//           fEnv("psFillColor", Black) ;
//                  fArrow(2.48,3, 1.77,3.5) ;
                  fTeXlabel(1.5,1.2, "cb", "${\\scriptstyle f=-10}$") ;
//           canvas.append( new fPsWrite(Red+"\n")) ;
//           fEnv("lineWidth", 1.0) ;

           C = -20; fCurve(new YP(C), 0.6, 1.4, OPEN) ;
                    fCurve(new YM(C), 0.6, 1.4, OPEN) ;
                    fCurve(new YP(C), 4.0, 4.7, OPEN) ;
//                    fCurve(new YM(C), 3.7, 5, OPEN) ;
                    fCurve(new YM(C), -1, -0.3, OPEN) ;

                    fCurve(new XP(C), 2.7, 7, OPEN) ;
                    fCurve(new XM(C), 2.7, 7.7, OPEN) ;
                    fCurve(new XP(C), -2, -0.3, OPEN) ;
                    fCurve(new XM(C), -2, -0.7, OPEN) ;
//           fEnv("lineWidth", 0.5) ;
//           canvas.append( new fPsWrite(Black+"\n")) ;
//           fEnv("psFillColor", Black) ;
//                  fArrow(2.48,3, 1.77,3.5) ;
                  fTeXlabel(0.8,3.5, "cl", "${\\scriptstyle f=-20}$") ;
                  fTeXlabel(4.05,-1.2, "tl", "${\\scriptstyle f=-20}$") ;
                  fTeXlabel(-0.8,-1.22, "tr", "${\\scriptstyle f=-20}$") ;
//                  fTeXlabel(-0.5,ymax, "cb", "${\\scriptstyle f=-20}$") ;
//           canvas.append( new fPsWrite(Red+"\n")) ;
//           fEnv("lineWidth", 1.0) ;


           C =  10; fCurve(new YP(C), 0.05, 4.7, OPEN) ;
                    fCurve(new YM(C), 0.05, 5, OPEN) ;
                    fCurve(new YP(C), -1, -0.2, OPEN) ;
                    fCurve(new YM(C), -1, -0.2, OPEN) ;

//                    fCurve(new XP(C), 0.05, 20, OPEN) ;
                    fCurve(new XM(C), 0.05, 20, OPEN) ;
//                    fCurve(new XP(C), -2, -0.3, OPEN) ;
//                    fCurve(new XM(C), -2, -0.3, OPEN) ;
//           fEnv("lineWidth", 0.5) ;
//           canvas.append( new fPsWrite(Black+"\n")) ;
//           fEnv("psFillColor", Black) ;
//                  fArrow(2.48,3, 1.77,3.5) ;
//                  fTeXlabel(2.5,3, "cl", "${\\scriptstyle f=0.25}$") ;
//           canvas.append( new fPsWrite(Red+"\n")) ;
//           fEnv("lineWidth", 1.0) ;

           C =  20; fCurve(new YP(C), 0.05, 4.7, OPEN) ;
                    fCurve(new YM(C), 0.05, 5, OPEN) ;
//                    fCurve(new YP(C), -1, -0.2, OPEN) ;
//                    fCurve(new YM(C), -1, -0.2, OPEN) ;

//                    fCurve(new XP(C), 0.05, 20, OPEN) ;
                    fCurve(new XM(C), 0.05, 20, OPEN) ;
//                    fCurve(new XP(C), -2, -0.3, OPEN) ;
//                    fCurve(new XM(C), -2, -0.3, OPEN) ;
//           fEnv("lineWidth", 0.5) ;
//           canvas.append( new fPsWrite(Black+"\n")) ;
//           fEnv("psFillColor", Black) ;
//                  fArrow(2.48,3, 1.77,3.5) ;
                  fTeXlabel(1.6,-1.7, "ct", "${\\scriptstyle f=20}$") ;
                  fTeXlabel(2.2,6, "cl", "${\\scriptstyle f=20}$") ;
                  fTeXlabel(-0.35,6, "cr", "${\\scriptstyle f=20}$") ;
//           canvas.append( new fPsWrite(Red+"\n")) ;
//           fEnv("lineWidth", 1.0) ;

         fEnv("psFillColor", Blue) ;
         fDisk(0,0,r,r*aspect, FILLED) ;
         fDisk(0,15,r,r*aspect, FILLED) ;
         fDisk(3,0,r,r*aspect, FILLED) ;
         fDisk(1,5,r,r*aspect, FILLED) ;

          
     }
}

class YP implements S2V {

   double C = 10 ;

   public YP(double C) {
        this.C = C ;
   }


   public double[] map(double t) {
          
          double[] out = {0,0} ;
          out[0] = t  ;
          out[1] =   0.5*( -5*t*(t-3) + Math.sqrt( 25*t*t*(t-3)*(t-3) + 4*t*C)  )/t ;
          return out ;
   }
}


class YM implements S2V {

   double C = 10 ;

   public YM(double C) {
        this.C = C ;
   }


   public double[] map(double t) {
          
          double[] out = {0,0} ;
          out[0] = t  ;
          out[1] =   0.5*( -5*t*(t-3) - Math.sqrt( 25*t*t*(t-3)*(t-3) + 4*t*C)  )/t ;
          return out ;
   }
}


class XP implements S2V {

   double C = 10 ;

   public XP(double C) {
        this.C = C ;
   }


   public double[] map(double t) {
          
          double[] out = {0,0} ;
          out[1] = t  ;
          out[0] =   0.1*( -t*(t-15) + Math.sqrt( t*t*(t-15)*(t-15) + 20*t*C)  )/t ;
          return out ;
   }
}


class XM implements S2V {

   double C = 10 ;

   public XM(double C) {
        this.C = C ;
   }


   public double[] map(double t) {
          
          double[] out = {0,0} ;
          out[1] = t  ;
          out[0] =   0.1*( -t*(t-15) - Math.sqrt( t*t*(t-15)*(t-15) + 20*t*C)  )/t ;
          return out ;
   }
}

