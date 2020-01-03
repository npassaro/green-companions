import React from 'react';
import PropTypes from 'prop-types';
import { ListGreensItem } from './list-greens-item.component';
import './list-greens.scss';

export const ListGreens = ({ greens=[], selectedGreen, onClick, onCompanionClick }) => (
  <table className="table table-striped table-hover ListGreens_table">
    <thead className="thead-dark ListGreens_row">
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
        <th className="ListGreens_cell" scope="col">
        </th>
      </tr>
    </thead>
    <tbody>
    {
      greens.map(green =>
        (<ListGreensItem
            key={green.id}
            green={green}
            onSelectClick={onClick}
            selectedGreen={selectedGreen}
            onCompanionClick={onCompanionClick}
        />)
      )
    }
    </tbody>
  </table>
);

ListGreens.propTypes = {
  greens: PropTypes.arrayOf(PropTypes.object).isRequired,
  selectedGreen: PropTypes.object,
  onClick: PropTypes.func.isRequired,
  onCompanionClick: PropTypes.func.isRequired,
};
