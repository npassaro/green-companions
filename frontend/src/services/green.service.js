import { backendUrl, COMPANION_TYPE } from './constants';

export const createGreen = (green) =>
  fetch(`${backendUrl}/api/1/green-companions`, {
    method: 'post',
    headers: {
      'Content-Type': 'application/json',
      'Accept': 'application/json'

    },
    body: JSON.stringify(green)
  })
  .then(response => {
    if (response.ok) {
      return response.json();
    }
    throw response;
  });


export const getAllGreens = () =>
  fetch(`${backendUrl}/api/1/green-companions`, {
    headers: {
      'Accept': 'application/json'
    }
  })
  .then(response => {
    if(response.ok) {
      return response.json()
    }
    throw response;
  })

export const requestCompanion = (method, type, id, companion) => {
    const typeName = type === COMPANION_TYPE.good ? 'good' : 'bad';
    return fetch(`${backendUrl}/api/1/green-companions/${id}/${typeName}-companions`,
      {
        method: method,
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json'
      },
      body: JSON.stringify(companion)
    })
    .then(response => {
      if (response.ok) {
        return response.json();
      }
      throw response;
    });
};
