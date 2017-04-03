// Generated code from Butter Knife. Do not modify!
package com.example.administrator.michart;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ECLoginActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.administrator.michart.ECLoginActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558526, "field 'etUsername'");
    target.etUsername = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131558527, "field 'etPsw'");
    target.etPsw = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131558528, "field 'btRegister' and method 'onClick'");
    target.btRegister = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131558529, "field 'bt' and method 'onClick'");
    target.bt = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
  }

  public static void reset(com.example.administrator.michart.ECLoginActivity target) {
    target.etUsername = null;
    target.etPsw = null;
    target.btRegister = null;
    target.bt = null;
  }
}
