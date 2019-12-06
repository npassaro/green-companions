import React from 'react';
import classNames from 'classnames';
import { MONTHS } from '../constants';
import './list-greens.scss';

export const ListGreensItem = ({green, onClick, isSelected }) => {
  const handleClick = () => onClick(green);
  return (
    <tr id={green.id} key={green.id} className={classNames('ListGreens_row', { 'ListGreens_row-selected': isSelected })} onClick={handleClick}>
      <td className="ListGreens_cell">
        {green.name}
      </td>
      <td className="ListGreens_cell">
        {green.description}
      </td>
      <td className="ListGreens_cell">
        {green.sowPeriod.map(period => <span key={period}>{getMonthName(period)}</span>)}
      </td>
      <td className="ListGreens_cell">
        {green.growPeriod.map(period => <span key={period}>{getMonthName(period)}</span>)}
      </td>
      <td className="ListGreens_cell">
        {green.harvestPeriod.map(period => <span key={period}>{getMonthName(period)}</span>)}
      </td>
    </tr>
  )
}

const getMonthName = (period) => (Object.values(MONTHS).find(m => m.key === period).name)
