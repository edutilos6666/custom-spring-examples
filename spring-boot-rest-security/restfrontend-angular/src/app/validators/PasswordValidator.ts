import { FormGroup } from '@angular/forms';

export class PasswordValidator {
  static validate(formGroup: FormGroup) {
    const password = formGroup.controls.password.value;
    const passwordRepeat = formGroup.controls.passwordRepeat.value;
    // console.log(formGroup.errors);
    if(passwordRepeat.length <= 0) {
      return null;
    }
    if(passwordRepeat !== password) {
      return {
        doesMatchPassword: true
      };
    }
    return null;
  }
}
