import React from 'react';
import { Checkbox } from '../checkbox';
import { MONTHS } from 'services/constants';

export class Period extends React.Component {
  constructor(props) {
    super(props);
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(e) {
    const isChecked = e.target.checked;
    const month = MONTHS[e.target.name];
    const { name , checkedMonths } = this.props;

    if (isChecked) {
      this.props.onChange({[name]: this.addMonth(month.key, checkedMonths) })
    } else {
      this.props.onChange({[name]: this.removeMonth(month.key, checkedMonths) })
    }
  }

  removeMonth(month, months) {
    return months.filter(m => month !== m);
  }
  addMonth(month, months) {
    return Array.from(new Set(months.concat(month))).sort((a, b)=> a-b);
  }

  isChecked(month, months) {
    return months.includes(month);
  }

  render() {
    const { checkedMonths } = this.props;
    return (
          Object.keys(MONTHS).map(month => (
            <div key={month} className="form-check">
              <Checkbox
                name={month}
                checked={this.isChecked(MONTHS[month].key, checkedMonths)}
                onChange={this.handleChange}
              />
              <label className="form-check-label" key={MONTHS[month].key} htmlFor={month}>
                {MONTHS[month].name}
              </label>
            </div>
          ))
    );
  }
}
