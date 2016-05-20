package com.jly.garfieldprojects.ui;

import android.app.Activity;
import android.os.Bundle;

import com.jly.garfieldprojects.R;

/**
 * Created by Administrator on 2016/5/19.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO}GridLayout 是一个非常强大的网格类布局
 *
 *
 * 基本概念

GridLayout把页面分成m行和n列，使用m+1条线和n+1条线，把页面共分成n*m个Cell。指定位置时行坐标是从0到m，列坐标是从0到n。每一个子View占一个或多个Cell。比如(0, 0)到(0, 1)就是占第一个Cell的区域。(0, 0), (0, 2)就是占第一行的2个Cell的区域(横向拉伸).

使用方法

主要介绍一下如何添加Cell，以及设置Cell的位置和拉伸。其他的跟普通的ViewGroup没什么区别的，也没啥好说的。

GridLayout的基本设置

首先需要给GridLayout设置行数和列数:

android:columnCount 整数，最多的列数
android:rowCount 整数，最多的行数
在添加Cell就需要注意，不能超过设置的最大行数和列数，否则在添加Cell时会有异常。

元素Cell的位置控制

添加Cell时需要指定其位置

android:layout_column 整数n，在哪一列开始显示n=[0, 最大列-1]
android:layout_columnSpan 整数k，指定元素横跨几列，需要注意保证n+k <= 最大列数
android:layout_row 指定从哪一行开始显示，规则同列数
android:layout_rowSpan 纵向跨几行，规则同列
行高和列宽的确定

每一行的高度是由这一行中Cell的最大高度决定的，以及每一列的宽度是由每一列中最大的宽度决定的，小于行高和列宽的元素可以设置其对齐方式和填充方式。

填充方式

通过Cell的android:layout_gravity参数来指定，Cell的填充方式，注意仅当Cell元素本身的尺寸小于它所占格子的大小时才有效，比如元素本身尺寸小于行高和列宽，或者当它占多行，或者占多列时：

center – 不改变元素的大小，仅居中
center_horizontal – 不改变大小，水平居中
center_vertical – 不改变大小，垂直居中
top – 不改变大小，置于顶部
left – 不改变大小，置于左边
bottom – 不改变大小，置于底部
right – 不改变大小，置于右边
start – 不改变大小，置于开头（这个是与RTL从右向左读的文字有关的，如果使用start/end，
那么当LTR文字时start=left,end=right，当RTL时start=right,end=left，也就是说系统会自动处理了)
end – 不改变大小，置于结尾
fill – 拉伸元素控件，填满其应该所占的格子
fill_vertical – 仅垂直方向上拉伸填充
fill_horizontal – 仅水平方向上拉伸填充
clip_vertical – 垂直方向上裁剪元素，仅当元素大小超过格子的空间时
clip_horizontal – 水平方向上裁剪元素，仅当元素大小超过格子的空间时
需要注意的是这些值是可以组合的，比如：

android:layout_gravity="center_vertical|clip_horizontal"
Cell之间的间距如何控制

默认间距

可以使用默认的间距android:useDefaultMargins=“true”或者GridLayout#setUseDefaultMargins()。这个属性默认值是”false”。

另外一种方式就是跟普通布局管理器一样，给每个Cell设置其margins

通常如果不满意系统的默认间距，就可以设置useDefaultMargins=“false”，然后通过给Cell设置margin来控制间距。

居中方法

仅有一个Cell或者仅有一行，或者仅有一列时

当仅有一个子View时或者仅有一行或者一列的时候，可以把每个Cell设置其android:layout_gravitiy=“center”
(相应代码为 LayoutParams#Gravity 为 CENTER )，就可以让其在GridLayout中居中。
 */
public class GridLayoutActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridlayout);

    }
}
