package com.udaky.animate;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class ThreadedTransitions {

    /**
     * This is an animations class Extension to the JavaFx animation
     * allowing one's to apply multiple Animations to the  particular Node
     * this is version 1.0
     * of this library
     * Animation's which are possible till now is
     * 1. FadeOut
     * 2. SlideFromLeft
     * 3. SlideFromRight
     * ComingSoon
     * 4.FadeIn
     * 5.ZoomIn
     * 6.ZoomOut
     * @createdBy  AkashKumarYadav copyright@2020
     */

        private  Node _node;
        private  Integer _time;



        /**
         * the following method is to provide a threaded animation which can run parallel
         * to another animation's this is only a extension to the javaFX library
         * @createdBy AkashKumarYadav
         * Below Functions extends <strong>Thread class</strong>
         * and User only has to make call to the Following Functions to make the animation's work
         * @Note: If user wants to make multiple animations on single node
         * then just make call to multiple animations functions the thread will automatically
         * handle that for you no need to Create Thread By YourSelf
         *

         * **/




        /** slide from right function **/
        public void slideFromRight(){

            class SlideFromRight extends Thread{

                public void run(){
                    // instantiates new Transition object
                    TranslateTransition transition = new TranslateTransition();
                    //take time from the parent class Transition
                    transition.setDuration(Duration.millis(_time));
                    transition.setFromX(_node.getLayoutX()+709);
                    transition.setFromY(0);
                    transition.setToY(0);
                    transition.setToX(0);
                    transition.setNode(_node);
                    transition.play();

                }
            }
            SlideFromRight slidefromright = new SlideFromRight();
            slidefromright.start();
        }
        public void slideFromLeft(){
            class SlideFromLeft extends Thread{
                public void run(){
                    TranslateTransition transition = new TranslateTransition();
                    transition.setDuration(Duration.millis(_time));
                    transition.setFromY(0);
                    transition.setFromX(-(_node.getLayoutX()+708));
                    transition.setToX(0);
                    transition.setToY(0);
                    transition.setNode(_node);
                    transition.play();
                }
            }
            SlideFromLeft slidefromleft = new SlideFromLeft();
            slidefromleft.start();
        }


}


