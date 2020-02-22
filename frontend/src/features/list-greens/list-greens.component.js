import React from 'react';
import PropTypes from 'prop-types';
import { ListGreensItem } from './list-greens-item.component';
import './list-greens.scss';

export const ListGreens = ({ greens=[], selectedGreen, onClick, onCompanionClick }) => (
  <table className="table table-sm table-striped table-hover ListGreens_table">
    <thead className="thead-dark ListGreens_headerRow">
      <tr>
        <th className="ListGreens_cell" scope="col">
          Name
        </th>
        <th className="ListGreens_cell" scope="col">
          Description
        </th>
        <th className="ListGreens_cell" scope="col">
          <div>Sow</div><div>Period</div>
        </th>
        <th className="ListGreens_cell" scope="col">
          <div>Grow</div><div>Period</div>
        </th>
        <th className="ListGreens_cell" scope="col">
          <div>Harvest</div><div>Period</div> 
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
