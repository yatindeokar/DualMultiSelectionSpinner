# MyDualMultiSelectionSpinner

MyDualMultiSelectionSpinner is a library that allows you to create a multi selection dialog with two sections of arraylist.


![dualspinnerdemo](https://user-images.githubusercontent.com/13361899/37876885-d1af4efa-3070-11e8-8f15-c452188f52ea.gif)



## Gradle Dependency

### Repository

Add this in your root build.gradle file ( not your module build.gradle file):
```xml
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```


## Dependency

Add this to your module's build.gradle file:

```xml
dependencies {
	        compile 'com.github.yatindeokar:DualMultiSelectionSpinner:v1.0.1'
	}

```

## Basic Usage



## Init from Java

### Implements to get MyDualMultiSelectionSpinner click listener

implements DualSpinnerListener

```java

MyDualMultiSelectionSpinner myDualMultiSelectionSpinner = new MyDualMultiSelectionSpinner(this,
                listOne,
                listTwo,
                listOneSelectedPosition,
                listTwoSelectedPosition);

        myDualMultiSelectionSpinner.setListener(this);
        myDualMultiSelectionSpinner.setLabels("LIST ONE LABEL", "LIST TWO LABEL");
        myDualMultiSelectionSpinner.setLabelOneStyle(30, R.color.colorAccent);
        myDualMultiSelectionSpinner.setLabelTwoStyle(30, R.color.colorPrimaryDark);
        myDualMultiSelectionSpinner.show();
                
```


## MIT License


        Copyright (c) 2017 Yatin I Deokar.

        Permission is hereby granted, free of charge, to any person obtaining a copy
        of this software and associated documentation files (the "Software"), to deal
        in the Software without restriction, including without limitation the rights
        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
        copies of the Software, and to permit persons to whom the Software is
        furnished to do so, subject to the following conditions:

        The above copyright notice and this permission notice shall be included in all
        copies or substantial portions of the Software.

        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
        SOFTWARE.
