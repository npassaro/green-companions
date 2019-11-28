import React from 'react';
import './list-greens.scss';
import { MONTHS } from '../constants';

export const ListGreens = ({ greens=[] }) =>
  (
    <table className="table ListGreens_table">
      <thead className="ListGreens_row">
        <tr>
          <th className="ListGreens_cell" scope="col">
            Name
          </th>
          <th className="ListGreens_cell" scope="col">
            Description
          </th>
          <th className="ListGreens_cell" scope="col">
            Sow Period
          </th>
          <th className="ListGreens_cell" scope="col">
            Grow Period
          </th>
          <th className="ListGreens_cell" scope="col">
            Harvest Period
          </th>
        </tr>
      </thead>
      <tbody>
      {
        greens.map(green => (
          <tr key={green.id} className="ListGreens_row">
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
        ))
      }
      </tbody>
    </table>
  );

const getMonthName = (period) => (Object.values(MONTHS).find(m => m.key === period).name)
